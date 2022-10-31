import init
import json
from tabulate import tabulate
from operator import itemgetter
lst=list()
def create_devices():
    device = {
        "name": init.get_info("name"),
        "Manifacture": init.get_info ("Manifacture"),
        "ports": init.get_info("ports"),
        "model": init.get_info("model"),
    }
    lst.append(device) 
    return  lst 

def getdata(value): 
    devices =()
    for i in range(value): 
        devices=create_devices() 
    return devices