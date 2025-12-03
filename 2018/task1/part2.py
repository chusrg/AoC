# Answer: 709
input_data = "input"

with open(input_data, "r", encoding="utf-8") as f:
    val = 0
    delta = []
    values = set()

    for line in f:
        line = line.rstrip("\n")
        delta.append((1 if line[0] == '+' else -1) * int(line[1:]))

    flag = True
    while flag:
        for d in delta:
            if val + d in values:
                flag = False
                val += d
                break
            else:
                values.add(val+d)

            val += d

    print(val)
