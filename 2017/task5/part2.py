# Answer: 30513679
input_data = "input"

with open(input_data, "r", encoding="utf-8") as f:
    mem = []
    for line in f:
        data = line.rstrip("\n")
        mem.append(int(data))

    ip, count = 0, 0
    try:
        while True:
            if mem[ip] >= 3:
                mem[ip] -= 1
                ip += mem[ip] + 1
            else:
                mem[ip] += 1
                ip += mem[ip] - 1
            count += 1
    except IndexError:
        print(count)
