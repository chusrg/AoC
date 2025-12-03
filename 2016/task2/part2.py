# Answer: 46C91

input_data = "input"

with open(input_data, "r", encoding="utf-8") as f:
    code = ""

    keyboard = [[' ', ' ', '1', ' ', ' '],
                [' ', '2', '3', '4', ' '],
                ['5', '6', '7', '8', '9'],
                [' ', 'A', 'B', 'C', ' '],
                [' ', ' ', 'D', ' ', ' ']]

    x = 2
    y = 0
    for line in f:
        for cmd in line:
            if cmd == 'U' and x != 0 and keyboard[x-1][y] != ' ':
                x -= 1
            elif cmd == 'D' and x != 4 and keyboard[x+1][y] != ' ':
                x += 1
            elif cmd == 'L' and y != 0 and keyboard[x][y-1] != ' ':
                y -= 1
            elif cmd == 'R' and y != 4 and keyboard[x][y+1] != ' ':
                y += 1

        code += keyboard[x][y]

    print(code)
