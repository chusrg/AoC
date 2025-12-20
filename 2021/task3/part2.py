# Answer: 3414905
from collections import Counter

input_data = "input"

def select_lines(lines: list, check):
    result = []

    for pos in range(0,len(lines[0])):
        s = []
        for j in range(0, len(lines)):
            s.append(lines[j][pos])

        c = Counter(s)
        for j in range(0, len(lines)):
            if lines[j][pos] == check(c):
                result.append(lines[j])

        if len(result) == 1:
            break

        lines = result
        result = []
        pos += 1

    return result

with (open(input_data, "r", encoding="utf-8") as f):
    lines_h, lines_v = [], []

    for line in f:
        lines_h.append(line.strip())

    a, b = int(select_lines(lines_h, lambda cC: ('0' if cC['0'] > cC['1'] else '1'))[0],2), \
           int(select_lines(lines_h, lambda cC: ('1' if cC['0'] > cC['1'] else '0'))[0],2)

    print(a * b)
