# Answer: 245102
input_data = "input"

with open(input_data, "r", encoding="utf-8") as f:

    sum_ids = 0
    for line in f:
        data = line.rstrip("\n").rsplit("-")
        id, crc = data[-1].rstrip("]").split("[")
        data.pop()

        m = dict()
        for d in data:
            for ch in d:
                if m.get(ch) == None:
                    m[ch] = 1
                else:
                    m[ch] += 1

        stat = sorted(list(m.items()), key=lambda x: (-x[1],x[0]))

        if ''.join([x[0] for x in stat[:5]]) == crc:
            sum_ids += int(id)

    print(sum_ids)
