# Requirements
!pip install requests
!pip install playwright
!pip install bs4
!pip install urllib3
!pip install argparse
!pip install nlpaug
!pip install torch transformers
!pip install transformers datasets sentencepiece
!pip install datasets


# Web Scraper
import requests
from bs4 import BeautifulSoup
from urllib.parse import urljoin
import re
import os

# INIT
visited_urls = set()
digits=set()
digits=('0','1','2','3','4','5','6','7','8','9',)
output_dir = "./scraped_texts"
filename = "scraped_content.txt"
filePath= os.path.join(output_dir, filename)
os.makedirs(output_dir, exist_ok=True)

def extract_paragraphs_and_code(soup, url):
    try:
      with open(filePath, "a", encoding="utf-8") as f:
        for tag in soup.find_all(["p","pre"]):
          text = tag.get_text(strip=True)
          if text.endswith(digits) or text.startswith(digits):
              continue
          else:
            f.write(text + "\n")
      print(f"[+] Saved content from {url} to {f}")
    except Exception as e:
        print(f"[!] Failed to save content from {url}: {e}")

def get_links(soup, base_url):
    links = []
    for a in soup.find_all("a", href=True):
        href = a["href"]
        full_url = urljoin(base_url, href)
        if full_url.startswith("http"):
            links.append(full_url)
    return links

def crawl(url, depth, max_depth):
    if url in visited_urls or depth > max_depth or len(visited_urls)>max_depth*100:
        return
    visited_urls.add(url)

    try:
        response = requests.get(url, timeout=10)
        if "text/html" not in response.headers.get("Content-Type", ""):
            return

        soup = BeautifulSoup(response.text, "html.parser")
        extract_paragraphs_and_code(soup, url)

        if depth < max_depth:
            for link in get_links(soup, url):
                crawl(link, depth + 1, max_depth)
    except Exception as e:
        print(f"[!] Failed to crawl {url}: {e}")

def main():
    start_url = "https://www.codequoi.com/en/"
    max_depth = 20
    crawl(start_url, 0, max_depth)

if __name__ == "__main__":
    main()


# Dataset Generator
import csv
import nlpaug.augmenter.word as naw

dataset = []
corpus_size=0

def corrupt_sentence(sentence):
    aug = naw.RandomWordAug(action="swap")
    noisy = aug.augment(sentence)
    return noisy
with open("./scraped_texts/scraped_content.txt", "r", encoding="utf-8") as f:
    clean_paragraphs = f.readlines()

for sentence in clean_paragraphs:
    clean = sentence.strip()
    if not clean or not re.search(r'[a-zA-Z0-9]', clean):
        continue
    noisy = corrupt_sentence(clean)
    if noisy and noisy != clean:
        dataset.append((noisy, clean))

# Save to CSV
with open("grammar_dataset.csv", "w", newline="", encoding="utf-8") as f:
    writer = csv.writer(f)
    writer.writerow(["input", "target"])
    for noisy, clean in dataset:
        corpus_size=corpus_size+1
        writer.writerow([noisy, clean])

print(f"[+] dataset created successfully corpus lenght:{corpus_size}")


# Model Training
from transformers import T5Tokenizer, T5ForConditionalGeneration, Trainer, TrainingArguments, DataCollatorForSeq2Seq
from datasets import Dataset
import pandas as pd
import os

os.environ["WANDB_DISABLED"] = "true"

df = pd.read_csv("grammar_dataset.csv")
dataset = Dataset.from_pandas(df)

# Load model and tokenizer
model_name = "t5-small"
tokenizer = T5Tokenizer.from_pretrained(model_name)
model = T5ForConditionalGeneration.from_pretrained(model_name)

def preprocess(example):
    input_text = "fix: " + example["input"]
    target_text = example["target"]
    inputs = tokenizer(input_text, truncation=True, padding="max_length", max_length=512)
    targets = tokenizer(target_text, truncation=True, padding="max_length", max_length=512)
    inputs["labels"] = targets["input_ids"]
    return inputs

tokenized_dataset = dataset.map(preprocess)

training_args = TrainingArguments(
    output_dir="./t5_grammar_model",
    per_device_train_batch_size=2,
    num_train_epochs=3,
    logging_dir="./logs",
    save_total_limit=2,
    logging_steps=10,
    max_steps=500,
)

data_collator = DataCollatorForSeq2Seq(tokenizer, model=model)

trainer = Trainer(
    model=model,
    args=training_args,
    train_dataset=tokenized_dataset,
    tokenizer=tokenizer,
    data_collator=data_collator,
)

trainer.train()

model.save_pretrained("./t5_grammar_model")
tokenizer.save_pretrained("./t5_grammar_model")

print("Training complete! Model saved to ./t5_grammar_model")
from transformers import AutoTokenizer, AutoModelForSeq2SeqLM

tokenizer = T5Tokenizer.from_pretrained("./t5_grammar_model")

model = T5ForConditionalGeneration.from_pretrained("./t5_grammar_model")
tokenizer = AutoTokenizer.from_pretrained("vennify/t5-base-grammar-correction")
model = AutoModelForSeq2SeqLM.from_pretrained("vennify/t5-base-grammar-correction")

def correct_grammar(text):
    print(f"before:{text}")
    input_text = "gec: " + text
    input_ids = tokenizer.encode(input_text, return_tensors="pt")
    outputs = model.generate(input_ids, max_length=128, num_beams=5)
    return tokenizer.decode(outputs[0], skip_special_tokens=True)

def grammar_checker(sentence="",nb=0):
  print(f"******OUTPUT X [{nb}]*****")
  if(sentence.strip()==""):
    print("Please enter a sentence")
  corrected_grammar=correct_grammar(sentence)
  print(f"after:{corrected_grammar}")

grammar_checker(sentence="went Sara to her school yestrday",nb=1)
grammar_checker(sentence="everwho do not love do not know God, because God he is thelove john 4:8.",nb=2)
grammar_checker(sentence=" heaviest burden is to exist without living ",nb=3)
