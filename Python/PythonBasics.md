#### [1 printing]
``` python
name="Freddy"
age=21
print(f"hello my name is {name} and my age is {age}")
print("hello my name is "+name+" and my age is "+str(age))
print("hello my name is ",name,"and my age is",age)

```
---
### [#2 variable]
``` python
name="fredy"
char='f'
integer=1
floatNumber=2.25
list1=[]
list2=list()
dic=[]
list_Of_dic=[{},{}]
print(name,"\n",char,"\n",integer,"\n",floatNumber)
```
---
### [#3 list in python or arrays]
``` python
names=['fredy',21,'johnny',48,'david',32,'chirstina',25]
print(names)
print("using string variable:")
for name in names: print(name)
#using index
print("using index:")
for i in range(len(names)): print(names[i])
```
### [#4 dictionary]
```Python
person = {
    'name': 'freddy',
    'age': '21',
    'major': 'computer-science'
}
print("all details:", person)
print(person[input("Enter detail option:")])
for keys,values in person.items():print(f"{keys:>8}:{values:>8}")
```
### [#5 list of dictionary]
```Python

people=[
    #items
    {
        #key  : #value
        'name':'freddy',
        'age':'21',
        'major':'computer-science'
    },{
        'name':'John',
        'age':'42',
        'major':'data-science'
    },{
        'name':'David',
        'age':'33',
        'major':'cyber-security'
    },
]
for persons in people: print(persons)
x=input("data option[name/age/major]:")
for i in range(len(people)): print(people[i][x])
devices=[
    {
        "name":"switchA18",
        "Manifacture":"ciscco",
        "ports":"24",
        "model":"MAOP18"
    },{
        "name":"switchB1",
        "Manifacture":"Aruba",
        "ports":"21",
        "model":"MBOP01"
    },{
        "name":"switchC19",
        "Manifacture":"intel",
        "ports":"23",
        "model":"CF846"
    }
]
print("<-----------List of devices------------->")
for i in range(len(devices)):
    for keys,values in devices[i].items():
        print(f"\t{keys:16s}:{values:}")
    print("<------------------------------------->")
```
### [#6 packages]
```python
#from <package> import <specific function>
#import <all package> 
#pip3 install tabulate
from tabulate import tabulate
import random
import string
from operator import itemgetter
devices = []
lst=["name","Manifacture","ports","model"]
for i in range(3):
    device={}
    for key in lst:     
        if(key=="name"):
            device[key]=("switch"
                +random.choice(string.ascii_letters).upper()
                +random.choice(string.digits))
        elif key=="Manifacture":
            device[key]=(random.choice(
                ["Intel","Ciscco","Aruba"]))
        elif key=="ports":
            port_num ="% s" % random.randint(10, 25)
            device[key] = port_num
        elif key=="model":
            model = ""
            for j in range(3):
                model +=random.choice(
                    string.ascii_letters).upper()
            for k in range(2):
                num = random.randint(0, 9)
                model += "%s" % num
            device[key]=model 
    devices.append(device)
	print(tabulate(sorted(devices, key=itemgetter("ports")), headers="keys"))
```
### [#7 flask]
``` Python 
#First pip3 install flask 
from flask import Flask
app=Flask(__name__)
@app.route('/')
def hello_world():
    return 'Hello, World
```
### [#8 functions]
```Python
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
```
### [#9 first create flask app route like]
```Python
# deploy flask server
export FLASK_ENV=development
export FLASK_APP=python_code.py
flask run
```
### [#10 modules]
```Python
#from <module> import <specific function>
#import <all module> 
from tabulate import tabulate
from operator import itemgetter 
import init
devices = []
if __name__=="__main__":
    for i in range(int(input("devices number:"))):
        devices.append(init.create_devices())
    print(tabulate(sorted(devices,key=itemgetter('ports')),headers="keys"),f"\ntotal devices created:{len(devices)}")
```
### [#11 strings]
```Python
device = "    switch L4,    Aruba,           10,     FHO89 "
print(f"string={device}")
print("-------------------------------------------------------------------")
print(f"print using split:\n     {device.split(',')}")
print("-------------------------------------------------------------------")
print(f"print using strip & split:\n     {device.strip().split(',')}")
print("-------------------------------------------------------------------")
print(f"remove blanks:\n     {device.replace(' ','').split(',')}")
print("-------------------------------------------------------------------")
print(f"replace comma with colomn:\n     {device.replace(' ','').replace(',',':')}","\n         this is just a string!")
print("--------------------------------------------
-----------------------")
print(f"loop with strip and split:     ")
print("\t",end='')
for item in device.split(','):
    print(f"{item.strip()}", end=',')
print("\n")
print("-------------------------------------------------------------------")
print("using comprehension:     ")
device_detail=[item.strip() for item in device.split(',')]
print(f"\t {device_detail}")
print("-------------------------------------------------------------------")
print("manipulate strings:")
model=input("\tdevice model:")
print(f"\tmodel uppercase:{model.upper()}")
print("-------------------------------------------------------------------")
print("Fiding in string:")
index = device.find(model)
print(f"\t{model} found at location {index}")
```
### [#12 comparison]
```Python
for i in range(len(devices)): 
    for keys,values in devices[i].items():
        if (keys == 'Manifacture') :
            if(values != 'Intel'):
                print(f"{devices[i]['name']}")
```
### [#13 netsed data]
```Python
def create_devices():
    device = {
        "name": "",
        "Manifacture": "",
        "ports": ['', '', '', ''],
        "model": "",
    }
    for key in device:
        if key=="ports":
            for i in range(random.randint(1, 4)):
                    device[key][i]=init.get_info(key)
        else: 
            device[key]=init.get_info(key)
    return device
```
### [#13 classes]
```Python

class device_key():
    key0="name"
    key1="Manifacture"
    key2="ports"
    key3="model"
def create_devices():
    device = {
        device_key.key0 : " ",
        device_key.key1 :"",
        device_key.key2 : ['', '', '', ''],
        device_key.key3: "",
    }
    for key in device:
        if key == "ports":
            for i in range(random.randint(1, 4)):
              device[key][i] = init.get_info(key)
        else:
            device[key] = init.get_info(key)
    return device
```
### [#14 list and dics comprehension]
```Python

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
```
### [#15 lists mutable]
```Python 

print("test 1")
lst1=[1,2,3,4]
print(f"list1:{lst1} list1 ID:{id(lst1)}")
lst2=lst1
print(f"list2:{lst2} list2 ID:{id(lst2)}")
if (id(lst1)==id(lst2)):
    print("\t\tSAME ID!")
print("---------------------------------------------")
print("test 2")
lst1=list()
def create_list(num):
    lst1.append(num)

for i in range(1,4):
    create_list(i)    
lst2=lst1
lst2.append(5)
print(f"list1:{lst1} list1 ID:{id(lst1)}")
print(f"list2:{lst2} list2 ID:{id(lst2)}")
if (id(lst1)==id(lst2)):
    print("\t\tSAME ID!")
```