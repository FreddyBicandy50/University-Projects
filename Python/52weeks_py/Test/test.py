import json 
import yaml 
import sys
from Devices import getdata  
from operator import itemgetter 
from tabulate import tabulate 

def create_dev(n_devices):
    #forcing normal input
    if n_devices=='':
        print('Invalid input!')
        sys.exit()

    elif int(n_devices)<0:
        print('number of devices should be >0')
    
    #store 
    with open("/home/null/programing/Python/52weeks_py/Test/data.json", "w") as json_in:
        json_in.write(json.dumps(getdata(int(n_devices)),indent=4))
        
    with open("/home/null/programing/Python/52weeks_py/Test/data.yaml", "w") as yaml_in:
        yaml_in.write(yaml.dump(getdata(int(n_devices))))
    
    #Request 
    yaml_inventory = 2
    with open("/home/null/programing/Python/52weeks_py/Test/data.yaml", "r") as yaml_out:
        yaml_inventory=(yaml.load(yaml_out))

    json_inventory = 1
    with open("/home/null/programing/Python/52weeks_py/Test/data.json", "r") as json_out:
        json_inventory=(json.load(json_out)) 
    
    return yaml_inventory, json_inventory

if __name__ == "__main__":

    #ask for input and print returned results
    yaml,json=create_dev(input("number of devices:")) 
    print(f'JASON FILE \n{tabulate(sorted(yaml, key=itemgetter("Manifacture")), headers="keys")}')
    print(f'\nYAML FILE  \n{tabulate(sorted(json, key=itemgetter("Manifacture")), headers="keys")}')
