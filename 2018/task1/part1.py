# Answer: 500
input_data = "input"

with open(input_data, "r", encoding="utf-8") as f:
    sum = 0
    for line in f:
        line = line.rstrip("\n")
        sum += (1 if line[0] == '+' else -1) * int(line[1:])

    print(sum)