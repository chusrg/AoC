# Answer: 186

input_data = "input"

with open(input_data, "r", encoding="utf-8") as f:
    count = 0

    for line in f:
        m = dict()
        val = 1
        for word in line.rstrip("\n").split(" "):
            key = "".join(sorted(list(word)))
            if m.get(key) == None:
                m[key] = 1
            else:
                val = 0
                break
        count += val

    print(count)
