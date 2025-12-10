# Answer: 1613
input_data = "input"

with open(input_data, "r", encoding="utf-8") as f:
    count, matrix = 0, []

    for line in f:
        matrix.append(line.strip("\n"))

    start = [matrix[0].find("S")]

    light = set(start)
    for i in range(1, len(matrix)):
        new_light = set()

        for j in range(0, len(matrix[0])):
            if matrix[i][j] == '^' and j in light:
                new_light.add(j-1)
                new_light.add(j+1)
                light.remove(j)
                count += 1

        if len(new_light) != 0:
            light.update(new_light)

    print(count)
