# Answer: 1136

input_data = "input"

with open(input_data, "r", encoding="utf-8") as f:
    line = f.read()

    digits = []
    for ch in line:
        digits.append(int(ch))
    digits.append(int(line[0]))

    sum = 0
    for i in range(1,len(digits)):
        if digits[i-1] == digits[i]:
            sum += digits[i]

    print(sum)