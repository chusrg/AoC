# Answer: 1067
import re

input_data = "input"

with open(input_data, "r", encoding="utf-8") as f:
    size, count = 1000, 0
    matrix = [[0 for _ in range(size)] for _ in range(size)]
    m_ids = [[[] for _ in range(size)] for _ in range(size)]
    areas = dict()

    for line in f:
        nums = list(map(int, re.findall(r"\d+", line)))
        n, x, y, w, h = nums
        areas[n] = w * h

        for i in range(0,w):
            for j in range(0,h):
                matrix[x+i][y+j] += 1
                m_ids[x+i][y+j].append(n)

    for i in range(0,size):
        for j in range(0,size):
            if len(m_ids[i][j]) == 1:
                areas[m_ids[i][j][0]] -= 1

    print(min(areas, key=areas.get))