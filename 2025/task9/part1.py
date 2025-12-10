# Answer: 4767418746
input_data = "input"

with open(input_data, "r", encoding="utf-8") as f:
    S, points = 0, list()

    for line in f:
        a, b = line.strip("\n").split(",")
        points.append((int(a), int(b)))

    sorted(points,reverse=True)

    for i in range(0, len(points)):
        for j in range(i + 1, len(points)):
            s = (abs(points[i][0] - points[j][0]) + 1) * (abs(points[i][1] - points[j][1]) + 1)
            if s > S:
                S = s

    print(S)