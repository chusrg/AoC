# Answer: 917
input_data = "input"

with open(input_data, "r", encoding="utf-8") as f:

    count = 0
    for line in f:
        line = line.rstrip("\n")
        a, b, c = [int(x) for x in line.split()]
        if a+b > c and b+c > a and c+a > b:
            count += 1
    print(count)
