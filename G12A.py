number = int(input("enter a number"))
isprime="YES"
if number > 1:
    for loop in range(2, number):
        if number%loop==0:
           isprime="NO"
           
if isprime=="YES":
    print(number," is a prime number")
else:
    print(number," is not a prime number")