#from <package> import <specific function>
#import <all package>
#pip3 install tabulate
from tabulate import tabulate
import random
import string
from operator import itemgetter
devices = []
lst = ["name", "Manifacture", "ports", "model"]
for i in range(3):
    device = {}
    for key in lst:
        if(key == "name"):
            device[key] = ("switch"
                           + random.choice(string.ascii_letters).upper()
                           + random.choice(string.digits))
        elif key == "Manifacture":
            device[key] = (random.choice(
                ["Intel", "Ciscco", "Aruba"]))
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
    devices.append(device)
print(tabulate(sorted(devices, key=itemgetter("ports")), headers="keys"))
