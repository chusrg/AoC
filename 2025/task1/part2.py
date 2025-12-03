# Answer: 6858
input_data = "input"

with open(input_data, "r", encoding="utf-8") as f:
    count = 0
    value = 50
    MAX_VAL = 100

    for line in f:
        line = line.rstrip("\n")
        delta = int(line[1:]) % MAX_VAL
        count += int(line[1:]) // MAX_VAL

        if line[0] == 'L':
            if value - delta < 0:
                if value != 0:
                    count += 1
                value = MAX_VAL + (value - delta)
            elif value - delta == 0:
                count += 1
                value = 0
            else:
                value -= delta
        else:
            if value + delta >= MAX_VAL:
                count += (value + delta) // MAX_VAL
                value = (value + delta) - MAX_VAL
            else:
                value += delta

    print(count)