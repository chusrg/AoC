# Answer: 1660158
input_data = "input"

with (open(input_data, "r", encoding="utf-8") as f):
    h, d = 0, 0

    for line in f:
        [cmd, val] = line.strip().split(" ")

        if cmd == "forward":
            h += int(val)
        elif cmd == "down":
            d += int(val)
        else:
            d -= int(val)

    print(h * d)
