
print("test 1")
lst1 = [1, 2, 3, 4]
print(f"list1:{lst1} list1 ID:{id(lst1)}")
lst2 = lst1
print(f"list2:{lst2} list2 ID:{id(lst2)}")
if (id(lst1) == id(lst2)):
    print("\t\tSAME ID!")
print("---------------------------------------------")
print("test 2")
lst1 = list()


def create_list(num):
    lst1.append(num)


for i in range(1, 4):
    create_list(i)
lst2 = lst1
lst2.append(5)
print(f"list1:{lst1} list1 ID:{id(lst1)}")
print(f"list2:{lst2} list2 ID:{id(lst2)}")
if (id(lst1) == id(lst2)):
    print("\t\tSAME ID!")
