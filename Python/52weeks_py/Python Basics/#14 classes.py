
class device_key():
    key0 = "name"
    key1 = "Manifacture"
    key2 = "ports"
    key3 = "model"


def create_devices():
    device = {
        device_key.key0: " ",
        device_key.key1: "",
        device_key.key2: ['', '', '', ''],
        device_key.key3: "",
    }
    for key in device:
        if key == "ports":
            for i in range(random.randint(1, 4)):
              device[key][i] = init.get_info(key)
        else:
            device[key] = init.get_info(key)
    return device
