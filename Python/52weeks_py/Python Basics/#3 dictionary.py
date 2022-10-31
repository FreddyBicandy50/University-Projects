person = {
    'name': 'freddy',
    'age': '21',
    'major': 'computer-science'
}
print("all details:", person)
print(person[input("Enter detail option:")])
for keys,values in person.items():print(f"{keys:>8}:{values:>8}")