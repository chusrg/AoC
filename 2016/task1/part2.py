# Answer: 140
import numpy as np

input_data = "input"

with open(input_data, "r", encoding="utf-8") as f:
    line = f.read()
    line = line.split(", ")

    start = np.array([0, 0])
    finish = start.copy()

    RL = np.array([[0, -1],
                   [1, 0]])
    RR = np.array([[0, 1],
                   [-1, 0]])

    go_left = np.array([-1, 0])
    go_right = np.array([1, 0])

    points_set = {tuple(start)}

    for cmd in line:
        step = int(cmd[1:])
        flag = False
        if cmd[0] == 'L':
            for i in range(0, step):
                finish += go_left
                if tuple(finish) in points_set:
                    flag = True
                    break
                points_set.add(tuple(finish))

            go_left = RL @ go_left
            go_right = RL @ go_right
        else:
            for i in range(0, step):
                finish += go_right
                if tuple(finish) in points_set:
                    flag = True
                    break
                points_set.add(tuple(finish))

            go_left = RR @ go_left
            go_right = RR @ go_right

        if flag:
            break

    res = finish - start
    print(abs(res[0])+abs(res[1]))
