# Answer: 455

input_data = "input"

with open(input_data, "r", encoding="utf-8") as f:
    count = 0

    for line in f:
        m = dict()
        val = 1
        for word in line.rstrip("\n").split(" "):
            if m.get(word) == None:
                m[word] = 1
            else:
                val = 0
                break
        count += val

    print(count)
