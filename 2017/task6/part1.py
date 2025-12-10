# Answer: 4074
input_data = "input"

with open(input_data, "r", encoding="utf-8") as f:
    line = f.read()
    mem = [int(x) for x in line.rstrip("\n").split("\t")]

    first, prev_mem, count, size = [], [], 0, len(mem)

    while True:
        max_element = max(mem)
        idx = mem.index(max_element)

        mem[idx] = 0
        for i in range(1, max_element+1):
            mem[(idx+i) % size] += 1

        count += 1

        if mem in prev_mem:
            break

        prev_mem.append(mem.copy())

print(count)
