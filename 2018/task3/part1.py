# Answer: 101469
import re

input_data = "input"

with open(input_data, "r", encoding="utf-8") as f:
    size, count = 1000, 0
    matrix = [[0 for _ in range(size)] for _ in range(size)]

    for line in f:
        nums = list(map(int, re.findall(r"\d+", line)))
        n, x, y, w, h = nums
        for i in range(0,w):
            for j in range(0,h):
                matrix[x+i][y+j] += 1

    for i in range(0,size):
        for j in range(0,size):
            if matrix[i][j] > 1:
                count += 1

    print(count)
