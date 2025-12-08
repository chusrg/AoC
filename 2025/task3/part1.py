# Answer: 17435
input_data = "input"

with open(input_data, "r", encoding="utf-8") as f:
    digits = ['9', '8', '7', '6', '5', '4', '3', '2', '1']

    sum = 0
    for line in f:
        line = line.rstrip("\n")

        flag = False
        val = ""
        for d1 in digits:
            pos = line.find(d1)
            if pos != -1:
                val = d1
                for d2 in digits:
                    if line.find(d2, pos+1) != -1:
                        val += d2
                        flag = True
                        break
            if flag:
                sum += int(val)
                break

    print(sum)