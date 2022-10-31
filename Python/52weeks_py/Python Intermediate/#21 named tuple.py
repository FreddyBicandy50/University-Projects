
from collections import namedtuple
Color_name = namedtuple('Color', ['Red', 'Green', 'Blue'])
color = Color_name(55, 155, 255)
print(f"Red:{color.Red}\nGreen:{color.Green}\nBlue:{color.Blue}")
