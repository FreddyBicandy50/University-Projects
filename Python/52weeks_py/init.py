#8 functions
import random
import string

def get_info(key):
    if(key == "name"):
        return ("switch"+ random.choice(string.ascii_letters).upper()+ random.choice(string.digits))
    elif key == "Manifacture":
        return (random.choice(["Intel", "Ciscco", "Aruba"]))
    elif key == "ports":
            port_num = "% s" % random.randint(10, 25)
            return port_num
    elif key == "model":
            model = ""
            for j in range(3):
                model += random.choice(
                    string.ascii_letters).upper()
            for k in range(2):
                num = random.randint(0, 9)
                model += "%s" % num
            return model
    
