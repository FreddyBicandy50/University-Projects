
people = [
    #items
    {
        #key  : #value
        'name': 'freddy',
        'age': '21',
        'major': 'computer-science'
    }, {
        'name': 'John',
        'age': '42',
        'major': 'data-science'
    }, {
        'name': 'David',
        'age': '33',
        'major': 'cyber-security'
    },
]
for persons in people:
    print(persons)
x = input("data option[name/age/major]:")
for i in range(len(people)):
    print(people[i][x])
devices = [
    {
        "name": "switchA18",
        "Manifacture": "ciscco",
        "ports": "24",
        "model": "MAOP18"
    }, {
        "name": "switchB1",
        "Manifacture": "Aruba",
        "ports": "21",
        "model": "MBOP01"
    }, {
        "name": "switchC19",
        "Manifacture": "intel",
        "ports": "23",
        "model": "CF846"
    }
]
print("<-----------List of devices------------->")
for i in range(len(devices)):
    for keys, values in devices[i].items():
        print(f"\t{keys:16s}:{values:}")
    print("<------------------------------------->")
