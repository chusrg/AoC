# Answer: 24862

input_data = "input"

with open(input_data, "r", encoding="utf-8") as f:
    code = ""
    keyboard = [['1', '2', '3'],
                ['4', '5', '6'],
                ['7', '8', '9']]

    x = y = 1
    for line in f:
        for cmd in line:
            if cmd == 'U' and x != 0:
                x -= 1
            elif cmd == 'D' and x != 2:
                x += 1
            elif cmd == 'L' and y != 0:
                y -= 1
            elif cmd == 'R' and y != 2:
                y += 1

        code += keyboard[x][y]

    print(code)
