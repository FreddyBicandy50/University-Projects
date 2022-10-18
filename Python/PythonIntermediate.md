### [#17 data Normalization]
```Python
while True:
    number_of_devices = input("number of devices:")
    if(number_of_devices.isdigit()):
        number_of_devices = int(number_of_devices)
        break
devices = [
    create_devices()
    for i in range(number_of_devices)
]

def search_device(device_name):    
   for i in range(len(devices)):
    for keys, values in devices[i].items():
        if (keys=="Manifacture" and values==device_name):
            for x,y in devices[i].items():
                if x != "Manifacture":
                    print(f"{x}: {y}",end=" ")
            print("")
if __name__ == "__main__":
    search_device(input("device name:").casefold())
```
### [#18 Tuple]
```Python
lst=list()
def create_devices():
    device = {
        "name": init.get_info(device_key.key0),
        "Manifacture": init.get_info(device_key.key1),
        "ports": init.get_info(device_key.key2), 
        "model": init.get_info(device_key.key3),
    }
    lst.append(device) 
    return tuple(lst)

if __name__ == "__main__": 
    devices =()
    for i in range(int(input("number of devices:"))):
        devices=create_devices() 
    print(tabulate(sorted(devices, key=itemgetter("Manifacture")),headers="keys"))
```
### [#20 sets]
```Python
first={1,2,3,4}
first.add(5)
first.remove(5)
second={9,1,5}

print(first | second)  # union
print(first & second) #intersect
print(first - second) #diffrence
print(first ^ second) #symetric diffrence
if 1 in first:
    print("yes")
```
### [#21 named tuple]
```Python

from collections import namedtuple
Color_name=namedtuple('Color',['Red','Green','Blue'])
color=Color_name(55,155,255)
print(f"Red:{color.Red}\nGreen:{color.Green}\nBlue:{color.Blue}")
```
### [Files]
```Python 
#22
#json 
import json
#Store
with open ("data.json","w") as json_in :
	json_in.write(json.dumps(devices))
#Get
json_inventory=list()
with open ("data.json","r") as json_out:
    json_inventory = json.load(json_out)

print(tabulate(sorted(json_inventory, key=itemgetter("Manifacture")),headers="keys"))
```