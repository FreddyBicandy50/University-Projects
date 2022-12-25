dimensions=int(input("enter the loops dimension:"))
sum1=0
sum2=0
def loop1():
    for i in range(dimensions):
        numbers=int(input("enter a number:"))
        sum1+=numbers
    return sum1
def loop2():
    for i in range(dimensions):
        numbers=int(input("enter a number:"))
        sum2+=numbers
    return sum2

print(loop1()+loop2())