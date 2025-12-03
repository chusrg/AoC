# Answer: 3892
from copy import deepcopy

input_data = "input"

with open(input_data, "r", encoding="utf-8") as f:
    program = [int(num) for num in f.read().split(',')]

    CONST = 19690720
    isStop = False

    for noun in range(100):
        for verb in range(100):
            mem = deepcopy(program)
            mem[1] = noun
            mem[2] = verb

            idx = 0
            while True:
                if mem[idx] == 99:
                    break
                elif mem[idx] == 1:
                    mem[mem[idx + 3]] = mem[mem[idx + 1]] + mem[mem[idx + 2]]
                elif mem[idx] == 2:
                    mem[mem[idx + 3]] = mem[mem[idx + 1]] * mem[mem[idx + 2]]
                idx += 4

            if mem[0] == CONST:
                print(100 * noun + verb)
                isStop = True
                break

        if isStop:
            break
