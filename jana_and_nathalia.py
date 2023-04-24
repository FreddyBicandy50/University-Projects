def select_category(machine):
    category=int(input("Select Categorie:"))
    if category==1:
        category="Chocolate"
    elif category==2:
        category="Chips&crackers"
    elif category==3: 
        category="Wafers"
    elif category==4: 
        category="Soft Drink"
    else: 
        return False 
  
    if(category): 
        print(machine[category])
        product=int(input("Select Product:")) 
        print(machine[category][product])
        return category 
    else:
        print("INVALID") 
  
     