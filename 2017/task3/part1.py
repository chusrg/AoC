# Answer: 419
import math

input_data = "input"

with open(input_data, "r", encoding="utf-8") as f:
    for line in f: pos = int(line)

    diag = int(math.sqrt(pos))
    if diag % 2 == 0:
        diag -= 1

    p = [(diag - 1) // 2 + 1, -(diag - 1) // 2]
    curr_pos = diag * diag + 1

    flag = True
    while curr_pos < pos:
        if flag:
            for i in range(0, diag):
                curr_pos += 1
                p[1] += 1
                if curr_pos == pos:
                    flag = False
                    break

        if flag:
            for i in range(0, diag+1):
                curr_pos += 1
                p[0] -= 1
                if curr_pos == pos:
                    flag = False
                    break

        if flag:
            for i in range(0, diag+1):
                curr_pos += 1
                p[1] -= 1
                if curr_pos == pos:
                    flag = False
                    break

        if flag:
            for i in range(0, diag+1):
                curr_pos += 1
                p[0] += 1
                if curr_pos == pos:
                    flag = False
                    break

    print(abs(p[0]) + abs(p[1]))
