# Answer: 6169101504608
import re

input_data = "input"

with (open(input_data, "r", encoding="utf-8") as f):
    result, data, ops = 0, [], []

    for line in f:
        if line.find("*") != -1 or line.find("+") != -1:
            ops = (re.sub(r" +", " ", line.strip().rstrip("\n"))).split(" ")
            break

        data.append((re.sub(r" +", " ", line.strip().rstrip("\n"))).split(" "))

    s = 0
    for i in range(0, len(ops)):
        s = int(data[0][i])
        op = ops[i]
        for j in range(1, len(data)):
            if op == '+':
                s += int(data[j][i])
            else:
                s *= int(data[j][i])
        result += s

    print(result)
