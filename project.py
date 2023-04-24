def vending_machine():
    machine = {
        "1:Chocolate":[
                        "1:KITKAT:0.49$",
                        "2:LEO:0.88$",
                        "3:ALBENI:0.25$",
                        "4:ALIA:0.51$",
                        "5:METRO:0.18$"
                    ],
        "2:Chips&crackers": [
                    [
                        "1.1:MASTER Regular:0.12$",
                        "1.2:MASTER cocktail:0.32$",
                        "1.3:MASTER Light:0.29$",
                        "1.4:MASTER Sitos:0.59$",
                        "1.5:MASTER Curvy:0.60$"
                    ],
                    [   
                        "2.1:Snips Corn:0.30$",
                        "2.2:Snips Baked:0.30$",
                        "2.3:Snips Oven:1.10$",
                        "2.4:MASTER Onion Rings:0.30$",
                        "2.5:MASTER Fries:0.60$"

                    ],
                    [
                        "3.1:Pringles Original:2.95$",
                        "3.2:Pringles Hot:2.86$",
                        "3.3:Pringles Vinegar:2.86$",
                        "3.4:Pringles Sour cream:2.95$"
                    ],
                    [
                        "4.1:Takis:1.80$",
                        "4.2:Pomsticks:0.96$",
                        "4.3:Curly:2.10$",
                        "4.4:Crix:0.41$"
                    ],[
                        "5.1:Crax:0.22$",
                        "5.2:Elephant:0.78$",
                        "5.3:Bruschette:0.87$",
                        "5.4:Gong:0.36$"
                    ]
                ], 
        "3:Wafers": [
                        "1:UNICA:0.14$",
                        "2:NOUBA:0.32$",
                        "3:Wafeup:0.36$",
                        "4:Break:0.21$",
                        "5:Halley:0.24$"
                    ], 
        "4:Soft Drink":[
                        "1:PEPSI:0.59$",
                        "2:Miranda:0.59$",
                        "3:7UP:0.59$",
                        "4:Coca-Cola:1.09$",
                        "5:Freez:0.89$"
                    ]
        } 
    for i in machine: 
        if(i=="2:Chips&crackers"):
            for j in machine[i]:
                print(j)

    return machine

def select_product(machine, product):
    if product in machine:
        return machine[product]
    else:
        return None

def calculate_price(price, quantity):
    return price * quantity

def buy_product(machine):
    product = input("Enter the product you want to buy: ")
    quantity = int(input("Enter the quantity you want to buy: "))
    price = select_product(machine, product)
    if price is None:
        print("Sorry, that product is not available.")
    else:
        total_price = calculate_price(price, quantity)
        print("Total price: ${:.2f}".format(total_price))

machine = vending_machine()
buy_product(machine)
