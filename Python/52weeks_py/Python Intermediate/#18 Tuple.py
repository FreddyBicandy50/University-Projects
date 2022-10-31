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