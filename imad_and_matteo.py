
def print_machine():
    machine = {
        "Chocolate":[
                        "1:Kitkat:1$",
                        "2:Leo:1$",
                        "3:Albeni:1$",
                        "4:Galaxy:1$",
                        "5:Metro:1$"
                    ],
        "Chips&crackers": [
                        "1:MASTER Regular:2$",
                        "2:Snips Baked:2$",
                        "3:Pringles Hot:2$",
                        "4:Pomsticks:2$",
                        "5:Elephant:2$"  
                ], 
        "Wafers": [
                        "1:UNICA:1.5$",
                        "2:NOUBA:1.5$",
                        "3:Wafeup:1.5$",
                        "4:Break:1.5$",
                        "5:Halley:1.5$"
                    ], 
        "Soft Drink":[
                        "1:PEPSI:2.5$",
                        "2:Miranda:2.5$",
                        "3:7UP:2.5$",
                        "4:Coca-Cola:2.5$",
                        "5:Freez:2.5$"
                    ]
        } 
    i=1
    for keys in machine:
        print(i,":",keys) 
        i+=1
    return machine