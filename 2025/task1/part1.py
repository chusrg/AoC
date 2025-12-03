# Answer: 1191
input_data = "input"

with open(input_data, "r", encoding="utf-8") as f:
    count = 0
    value = 50
    MAX_VAL = 100

    for line in f:
        line = line.rstrip("\n")

        if line[0] == 'L':
            value -= int(line[1:]) % MAX_VAL
        else:
            value += int(line[1:]) % MAX_VAL

        if value < 0:
            value = value + MAX_VAL
        elif value >= MAX_VAL:
            value = value % MAX_VAL

        if value == 0:
            count += 1

    print(count)