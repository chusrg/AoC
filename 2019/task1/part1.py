# Answer: 3372695
import math

input_data = "input"

with open(input_data, "r", encoding="utf-8") as f:
    sum = 0
    for line in f:
        line = line.rstrip("\n")
        sum += math.floor(int(line) / 3) - 2

    print(sum)