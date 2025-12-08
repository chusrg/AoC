# Answer: 1649
input_data = "input"

with open(input_data, "r", encoding="utf-8") as f:
    count = 0
    data = []

    for line in f:
        line = line.rstrip("\n")
        data.append([int(x) for x in line.split()])

    check_triangle = lambda a,b,c: a + b > c and b + c > a and c + a > b

    for i in range(0, len(data) // 3):
        count += 1 if check_triangle(data[3*i][0], data[3*i + 1][0], data[3*i + 2][0]) else 0
        count += 1 if check_triangle(data[3*i][1], data[3*i + 1][1], data[3*i + 2][1]) else 0
        count += 1 if check_triangle(data[3*i][2], data[3*i + 1][2], data[3*i + 2][2]) else 0

    print(count)
