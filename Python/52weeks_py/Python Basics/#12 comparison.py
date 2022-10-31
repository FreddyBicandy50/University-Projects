for i in range(len(devices)):
    for keys, values in devices[i].items():
        if (keys == 'Manifacture'):
            if(values != 'Intel'):
                print(f"{devices[i]['name']}")
