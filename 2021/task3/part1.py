# Answer: 4191876
from collections import Counter

input_data = "input"

with (open(input_data, "r", encoding="utf-8") as f):
    lines_h, v_str = [], []

    for line in f:
        lines_h.append(line.strip())

    for i in range(0, len(lines_h[0])):
        s = []
        for j in range(0, len(lines_h)):
            s.append(lines_h[j][i])
        c = Counter(s)
        v_str.append('1' if c['0'] > c['1'] else '0')

    a = int("".join(v_str), 2)
    b = ((2 << len(v_str) - 1) - 1) - a

    print(a * b)