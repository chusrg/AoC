# Answer: 1604592846
input_data = "input"

with (open(input_data, "r", encoding="utf-8") as f):
    h, d, goal = 0, 0, 0

    for line in f:
        [cmd, val] = line.strip().split(" ")

        if cmd == "forward":
            h += int(val)
            d += goal * int(val)
        elif cmd == "down":
            goal += int(val)
        elif cmd == "up":
            goal -= int(val)

    print(h * d)
