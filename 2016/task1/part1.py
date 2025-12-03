# Answer: 181
import numpy as np

input_data = "input"

with open(input_data, "r", encoding="utf-8") as f:
    line = f.read().split(", ")

    start = np.array([0, 0])
    finish = start.copy()

    RL = np.array([[0, -1],
                   [1, 0]])
    RR = np.array([[0, 1],
                   [-1, 0]])

    go_left = np.array([-1, 0])
    go_right = np.array([1, 0])

    for cmd in line:
        step = int(cmd[1:])
        if cmd[0] == 'L':
            finish += step * go_left
            go_left = RL @ go_left
            go_right = RL @ go_right
        else:
            finish += step * go_right
            go_left = RR @ go_left
            go_right = RR @ go_right

    res = finish - start
    print(abs(res[0])+abs(res[1]))