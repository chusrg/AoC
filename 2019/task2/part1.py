# Answer: 7210630

input_data = "input"

with open(input_data, "r", encoding="utf-8") as f:
    program = [int(num) for num in f.read().split(',')]

    program[1] = 12
    program[2] = 2

    idx = 0
    while idx < len(program):
        if program[idx] == 99:
            break
        elif program[idx] == 1:
            program[program[idx+3]] = program[program[idx+1]] + program[program[idx+2]]
        elif program[idx] == 2:
            program[program[idx+3]] = program[program[idx+1]] * program[program[idx+2]]

        idx += 4

    print(program[0])
