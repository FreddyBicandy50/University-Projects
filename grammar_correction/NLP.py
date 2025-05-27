!pip install requests
!pip install bs4
!pip install argparse
!pip install nlpaug
!pip install torch transformers
!pip install transformers datasets sentencepiece
!pip install datasets
!pip install tqdm


Examples_bank=[
    "She go store yesterday",
    "everwho do not love do not know God, cz God he is  love the john 4:8.",
    "In moder day pepols often neglects the importance of nature because are busy on their phon,and this cause serious mental health issue and loss of touch with realty which MAKE society worse.",
]




import requests
from bs4 import BeautifulSoup
from urllib.parse import urljoin
from tqdm import tqdm
import string
import re
import os

def is_ascii_printable(text):
    return bool(re.fullmatch(rf"[{re.escape(string.printable)}]+", text))

'''
  checks our text if contains and:
    # Remove empty or whitespace-only text
    # Skip texts containing URLs
    # Skip texts that contain mostly non-ASCII characters (e.g., garbled text like â€¦)
    # Ensure text starts and ends with alphabetic character
'''
def is_valid_text(text):
    if not text or not text.strip():
        return False

    if re.search(r'https?://\S+', text):
        return False

    if not is_ascii_printable(text):
        return False

    if not re.match(r'^[\x20-\x7E]', text) or not re.search(r'[\x20-\x7E]$', text):
        return False

    symbols = ";{}=()<>+-*/%&|"
    symbol_count = sum(text.count(s) for s in symbols)
    word_count = len(text.split())
    if word_count < 5 or (symbol_count / word_count) > 1.5:
        return False

    return True


'''
  find and extracts all p/pre tags
    if a tag is found within a parent header,footer,nav
      skip it considering it is a useless tag or advretisment.
    else
      save content and display success message
    the code wraped within a try method to ensure code runs even if an error occurs on unreachable websites.
'''
def extract_paragraphs_and_code(soup, url):
    try:
        with open(filePath, "a", encoding="utf-8") as f:
            for tag in soup.find_all(["p", "pre"]):
                if tag.find_parent(["header", "footer", "nav"]):
                    continue

                text = tag.get_text(strip=True)
                if not is_valid_text(text):
                   continue
                scraped_text.add(text)
    except Exception as e:
        print(f"[!] Failed to save content from {url}: {e}")

'''
  soup will find all anchor tags <a> which redirects to another page
    the url should start with http..
    if true:
      bank of links will have a new url to visit
'''
def get_links(soup, base_url):
    links = []
    for a in soup.find_all("a", href=True):
        href = a["href"]
        full_url = urljoin(base_url, href)
        if full_url.startswith("http"):
            links.append(full_url)
    return links
'''
  crawl function will make sure our recursive stop after the specified max_depth
  each visited url will marked
  all requests shall timeiout after 10s
  if the response of a request is not text/html slip that
  soup will convert all responses to html pretty much like curl
'''
def crawl(url, depth, max_depth,pbar):

    if url in visited_urls or depth > max_depth or len(visited_urls)>max_depth*100:
        return
    visited_urls.add(url)
    try:
      response = requests.get(url, timeout=10)
      if "text/html" not in response.headers.get("Content-Type", ""):
        return

      soup = BeautifulSoup(response.text, "html.parser")
      extract_paragraphs_and_code(soup, url)

      pbar.update(1)

      if depth < max_depth:
        for link in get_links(soup, url):
          crawl(link, depth + 1, max_depth,pbar)
    except Exception as e:
      print(f"[!] Failed to crawl {url}: {e}")
      pbar.update(1)
      
      
      
'''
  # initialising base variables for visited urls
  # defining saved content path/directory
  # creating directory if it doesn't exist
  # creating file if it doesn't exist
'''
visited_urls = set()
scraped_text=set()
output_dir = "./scraped_texts"
filename = "scraped_content.txt"
base_url = "https://en.wikipedia.org/wiki/Love"
max_depth = 80
filePath= os.path.join(output_dir, filename)
os.makedirs(output_dir, exist_ok=True)

def main():

    print("Welcome to WebScraper v2.5 🕸")

    with tqdm(total=max_depth * 100, desc='Crawling') as pbar:
        crawl(base_url, 0, max_depth, pbar)

    print("\n*******************************************************************\nsaving scraped text into files")
    count = 0
    with open(filePath, "w", encoding="utf-8") as f:
        for text in scraped_text:
            f.write(text + "\n")
            count += 1
    print(f"[+] {count} lines saved successfully into {filePath}\n*******************************************************************")

if __name__ == "__main__":
    if os.path.exists(filePath):
      os.remove(filePath)
    main()
    
    
import csv
import os
import nlpaug.augmenter.word as naw
import nltk
from tqdm import tqdm
nltk.download('averaged_perceptron_tagger_eng')
nltk.download('wordnet')
nltk.download('omw-1.4')


'''
  this function will read scraped content from a file path
  while reading tqdm will display line bar
'''

def read_scraped_content(path):
    print(f"Reading Scraped Content file name: [{os.path.basename(path)}]")
    sentences = set()
    with open(path, 'r') as f:
        with tqdm(total=os.path.getsize(path), unit='B', unit_scale=True, desc='Reading File') as pbar:
            for line in f:
                sentences.add(line)
                pbar.update(len(line.encode('utf-8')))
    return sentences


'''
  the generated noise function will use the nltk library to swap some words with its synonmys rather
  than swaping words wich makes more grammar mistakes and more realistic for model to train
'''
def generate_noise(sentence):
    aug = naw.SynonymAug(aug_src='wordnet', aug_p=0.2)
    return aug.augment(sentence)


'''
  this function will open the filename and use all read sentences by writing once
  in a csv filename the input and target cols
  once written then using a pBar reading each sentnce and generating noise up on it
    the nosiy shall not be equal to the sentence
'''
def noise_generator(filename, sentences):
    corpus_size = 0
    with open(filename, "w", newline="") as outfile:
        writer = csv.writer(outfile)
        writer.writerow(["input", "target"])  # Write header only once
        with tqdm(total=len(sentences), desc='Generating Noisy Data') as progress_bar:
            for sentence in sentences:
                noisy = generate_noise(sentence)
                if noisy and noisy != sentence:
                    writer.writerow([noisy, sentence])
                    corpus_size += 1
                progress_bar.update(1)
    print(f"Generated {corpus_size} noisy sentence pairs in {filename}")
    return corpus_size

def main():
    sentences = read_scraped_content("./scraped_texts/scraped_content.txt")
    corpus_size = noise_generator("grammar_dataset.csv", sentences)
    print(f"[+] Dataset created successfully. Corpus length: {corpus_size} line")

if __name__ == "__main__":
    main()
    
from transformers import T5Tokenizer,T5ForConditionalGeneration,TrainingArguments,Trainer,DataCollatorForSeq2Seq
from transformers import pipeline
from datetime import timedelta
from datasets import Dataset
import pandas as pd
import os
import torch


'''
  -using padnas load the generated dataset above
  -split our dataset between trainning and validation 90-10%
  -using t5 model from huggingface (small model) note that the small model can fit arround 65_million word per request
  -Load model and tokenizer
'''
df = pd.read_csv("grammar_dataset.csv")
dataset = Dataset.from_pandas(df)

split_dataset = dataset.train_test_split(test_size=0.1)

model_name = "t5-small"
tokenizer = T5Tokenizer.from_pretrained(model_name)
model = T5ForConditionalGeneration.from_pretrained(model_name)


'''
  apply splitting to the dataset,which will be split into train,test
  training configuration:
    # Where to save the model.
    # Uses small batch size (2) per GPU/CPU.
    # Train for 3 full passes over the data.
    # Enables eval
    # Evaluate every 50 steps
    # Save every eval
  Dynamically pads sequences in a batch, so all examples have the same length during training — efficient & necessary for seq2seq tasks.
  configure the train model
  training model with trainer.train()
'''
def model_train(start):
  print("-map dataset")
  tokenized_dataset = split_dataset.map(preprocess)

  print("-configure training")
  training_args = TrainingArguments(
      output_dir="./contentt5_grammar_model",
      per_device_train_batch_size=8,
      num_train_epochs=1,
      logging_dir="./logs",
      save_total_limit=2,
      logging_steps=10,
      max_steps=500,
      eval_strategy="steps",
      eval_steps=50,
      save_strategy="steps",
      save_steps=50,
      report_to="none"
  )
  print("-configure trainer")
  data_collator = DataCollatorForSeq2Seq(tokenizer, model=model)
  print("-start training")
  trainer = Trainer(
      model=model,
      args=training_args,
      train_dataset=tokenized_dataset["train"],
      eval_dataset=tokenized_dataset["test"],
      tokenizer=tokenizer,
      data_collator=data_collator,
  )

  trainer.train()

  model.save_pretrained("./t5_grammar_model")
  tokenizer.save_pretrained("./t5_grammar_model")

  print("Training complete! Model saved to ./t5_grammar_model")

print(f"using {torch.cuda.get_device_name(0)} GPU")
model_train(start="startTraining")


'''
  this method tells the T5 model what task its supposed to perform
  we are using in this case, grammar correction
  T5 support more than grammer fixes and this will ensure to that the output will be a correct sentence
'''
def preprocess(example):
    input_text = "grammar: " + example["input"]
    target_text = example["target"]
    model_input = tokenizer(input_text, max_length=128, truncation=True)
    label = tokenizer(target_text, max_length=128, truncation=True)
    model_input["labels"] = label["input_ids"]
    return model_input

'''
  here we will Prepends the task prefix "gec: " to tell the T5 model what you're asking it to do.
  "GEC" = Grammatical Error Correction
  T5 uses task-specific prefixes to understand the goal of the prompt.
  Tokenizes and encodes the input string into token IDs, which the model needs for inference.
  model.generate:Generates the corrected text using the model.
'''
def correct_grammar(text):
    input_text = "grammar: " + text
    input_ids = tokenizer.encode(input_text, return_tensors="pt").to(model.device)

    outputs = model.generate(
        input_ids,
        max_length=128,
        num_beams=5,
        no_repeat_ngram_size=3,
        repetition_penalty=1.5
    )

    decoded = tokenizer.decode(outputs[0], skip_special_tokens=True)
    cleaned = '. '.join(dict.fromkeys(decoded.split('. ')))
    return cleaned

'''
  program runtime function
'''
def grammar_fixer(sentence):
    if sentence.strip() == "":
        print("Please enter a sentence")
        return
    return (correct_grammar(sentence))

'''
  choosing between a pre-trained model or our trained which is saved in
  ./t5_grammar_model folder config
'''
def model_option(pretrained):
  global tokenizer, model
  if (pretrained) :
    tokenizer = T5Tokenizer.from_pretrained("vennify/t5-base-grammar-correction")
    model = T5ForConditionalGeneration.from_pretrained("vennify/t5-base-grammar-correction")
  else :
    tokenizer = T5Tokenizer.from_pretrained("t5_grammar_model")
    model = T5ForConditionalGeneration.from_pretrained("t5_grammar_model")
    
    
def main():
  number=1
  for text in Examples_bank:
    print(f"\t\n Example {number}")
    print(f"Before: {text}")
    print(f"After: {grammar_fixer(text)}")
    number+=1

if __name__ == "__main__":
    print("***Our Generated Model Result:****")
    model_option(False)
    main()
    print("\n\n***Pre-trained model Result:****")
    model_option(True)
    main()