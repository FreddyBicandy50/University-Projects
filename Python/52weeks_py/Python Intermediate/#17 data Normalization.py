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
    