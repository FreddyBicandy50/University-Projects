from tabulate import tabulate
import random
import string
from operator import itemgetter

lst = ["name", "Manifacture", "ports", "model"]
def create_devices(key):  
    if(key == "name"):
     device[key] = ("switch"+ random.choice(string.ascii_letters).upper()+ random.choice(string.digits))
    elif key == "Manifacture":
        device[key] = (random.choice(["Intel", "Ciscco", "Aruba"]))
    elif key == "ports":
            port_num = "% s" % random.randint(10, 25)
            device[key] = port_num
    elif key == "model":
            model = ""
            for j in range(3):
                model += random.choice(
                    string.ascii_letters).upper()
            for k in range(2):
                num = random.randint(0, 9)
                model += "%s" % num
            device[key] = model
    return device

if __name__=="__main__":
    devices = list()
    for i in range(5): 
        device=dict()
        for key in lst:
            device=create_devices(key)
        devices.append(device)

print(tabulate(sorted(devices, key=itemgetter("ports")),headers="keys")+f"\ntotal devices {len(devices)}")