# Answer: 295229

input_data = "input"

with open(input_data, "r", encoding="utf-8") as f:
    for line in f: pos = int(line)
    size = 1000
    matrix = [[0 for _ in range(size)] for _ in range(size)]

    calc_val = lambda m, x, y:  \
        m[x][y + 1] + m[x][y - 1] + \
        m[x + 1][y] + m[x - 1][y] + \
        m[x + 1][y + 1] + m[x - 1][y - 1] + \
        m[x + 1][y - 1] + m[x - 1][y + 1]

    p = [size // 2, size // 2]
    matrix[p[0]][p[1]] = 1
    matrix[p[0]+1][p[1]] = 1
    p[0] += 1

    diag = 1
    curr_pos = 1

    flag = True
    while curr_pos < pos:
        if flag:
            for i in range(0, diag):
                p[1] += 1
                curr_pos = calc_val(matrix, p[0], p[1])
                matrix[p[0]][p[1]] = curr_pos

                if curr_pos > pos:
                    flag = False
                    break

        if flag:
            for i in range(0, diag+1):
                p[0] -= 1
                curr_pos = calc_val(matrix, p[0], p[1])
                matrix[p[0]][p[1]] = curr_pos

                if curr_pos > pos:
                    flag = False
                    break

        if flag:
            for i in range(0, diag+1):
                p[1] -= 1
                curr_pos = calc_val(matrix, p[0], p[1])
                matrix[p[0]][p[1]] = curr_pos

                if curr_pos > pos:
                    flag = False
                    break

        if flag:
            for i in range(0, diag+1):
                p[0] += 1
                curr_pos = calc_val(matrix, p[0], p[1])
                matrix[p[0]][p[1]] = curr_pos

                if curr_pos > pos:
                    flag = False
                    break

        if curr_pos > pos:
            break

        p[0] += 1
        curr_pos = calc_val(matrix, p[0], p[1])
        matrix[p[0]][p[1]] = curr_pos

        diag += 2

    print(curr_pos)
