def payment(category):
    if category=="Chocolate":
        calc(1)
    elif category=="Chips&crackers":
        calc(2)
    elif category=="Wafers":
        calc(1.5)
    else:
        calc(2.5)

def calc(price): 
    pay=int(input("please pay price above:"))

    if pay<price:
        print("Not enough ammount of money")
    elif pay>price:
        print("Thank you here's your change",pay-price)
    else:
        print("Thank you")