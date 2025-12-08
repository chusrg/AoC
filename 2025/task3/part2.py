# Answer: 172886048065379
input_data = "input"

with open(input_data, "r", encoding="utf-8") as f:
    digits = ['9', '8', '7', '6', '5', '4', '3', '2', '1']

    sum = 0
    for line in f:
        line = line.rstrip("\n")

        val = ""
        target = 12
        pos = -1

        while target != 0:
            for d in digits:
                pos = line.find(d)
                if pos != -1:
                    if len(line) - pos < target:
                        continue
                    else:
                        val += d
                        target -= 1
                        line = line[pos+1:]
                        break

        print(f"{line} => {val}")
        sum += int(val)

    print(sum)
