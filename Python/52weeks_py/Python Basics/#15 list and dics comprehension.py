
import init
import random 
from tabulate import tabulate
from operator import itemgetter
class device_key():
    key0="name"
    key1="Manifacture"
    key2 = "ports"
    key3="model"
def create_devices():
    device = {
        device_key.key0: init.get_info(device_key.key0),
        device_key.key1: init.get_info(device_key.key1),
        device_key.key2:[init.get_info(device_key.key2) for i in range(random.randint(1,4))],
        device_key.key3: init.get_info(device_key.key3),
    }
    return device
    
if __name__ == "__main__":
    #list comprehension
    devices =[
        create_devices()
        for i in range(int(input("number of devices:")))
    ]
    print(tabulate(sorted(devices, key=itemgetter("Manifacture")),headers="keys"))