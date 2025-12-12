# Answer:
import math

input_data = "input"

with open(input_data, "r", encoding="utf-8") as f:
    matrix = []

    for line in f:
        matrix.append(list(line.strip()))

    x_size, y_size = len(matrix[0]), len(matrix)

    counts = []
    for (dx, dy) in [(1, 1), (1, 3), (1, 5), (1, 7), (2, 1)]:
        i, j, count = 0, 0, 0

        while j < y_size:
            if matrix[j][i] == '#':
                count += 1

            i = (i + dy) % x_size
            j += dx
        counts.append(count)

    print(math.prod(counts))