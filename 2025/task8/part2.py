# Answer:
input_data = "input"

with open(input_data, "r", encoding="utf-8") as f:
    points = list()

    for line in f:
        a, b, c = line.strip("\n").split(",")
        points.append((int(a), int(b), int(c)))

    print(points)