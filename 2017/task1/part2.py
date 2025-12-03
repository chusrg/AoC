# Answer: 1092

input_data = "input"

with open(input_data, "r", encoding="utf-8") as f:
    line = f.read()

    digits = []
    for ch in line:
        digits.append(int(ch))

    size = len(digits)
    step = size // 2

    for i in range(0,step):
        digits.append(int(line[i]))

    sum = 0
    for i in range(0,size):
        if digits[i] == digits[i+step]:
            sum += digits[i]

    print(sum)