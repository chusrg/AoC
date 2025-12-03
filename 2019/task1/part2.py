# Answer:
import math

input_data = "input"

def calc(mass: int) -> int:
    val = math.floor(int(mass) / 3) - 2
    sum = val

    while True:
        val = math.floor(int(val) / 3) - 2
        if val < 0:
            break
        sum += val

    return sum

with open(input_data, "r", encoding="utf-8") as f:
    sum = 0
    for line in f:
        line = line.rstrip("\n")
        sum += calc(int(line))

    print(sum)
