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