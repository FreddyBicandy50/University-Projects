first = {1, 2, 3, 4}
first.add(5)
first.remove(5)
second = {9, 1, 5}

print(first | second)  # union
print(first & second)  # intersect
print(first - second)  # diffrence
print(first ^ second)  # symetric diffrence
if 1 in first:
    print("yes")
