# Answer:
input_data = "input"

with open(input_data, "r", encoding="utf-8") as f:
    size, count = 1000, 0
    matrix = []

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
            elif matrix[i][j] == '.' and j in light:
                matrix[i] = "".join(matrix[i][:j]) + "|" + "".join(matrix[i][j+1:])

        if len(new_light) != 0:
            light.update(new_light)
            # count += len(light)

    for i in range(0, len(matrix)):
        print("".join(matrix[i]))

    c = 0
    for i in range(2, len(matrix)):
        for j in range(0, len(matrix[0])):
            if matrix[i][j] == '^' and matrix[i-1][j] == '|':
                c += 1

    print(count)
    print(c)
