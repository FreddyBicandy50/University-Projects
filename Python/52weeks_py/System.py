import init
import json
from tabulate import tabulate
from operator import itemgetter
lst=list()

def create_devices():
    device = {
        "name": init.get_info("name"),
        "Manifacture": init.get_info("Manifacture"),
        "ports": init.get_info("ports"),
        "model": init.get_info("model"),
    }
    lst.append(device) 
    return tuple(lst)

if __name__ == "__main__": 
    devices =()
    for i in range(int(input("number of devices:"))):
        devices=create_devices() 
    with open("test.json","w") as json_in :
        json_out.write(json.dumps(devices))
    