# Answer: umdryabviapkozistwcnihjqx

input_data = "input"

with open(input_data, "r", encoding="utf-8") as f:
    ids = []
    for line in f:
        ids.append(line)

    ids = sorted(ids)

    for i in range(0, len(ids) - 1):
        count = 0
        res = ""

        for pos in range(0, len(ids[0])):
            if ids[i][pos] == ids[i + 1][pos]:
                res += ids[i][pos]
            else:
                count += 1

            if count > 1:
                break

        if count == 1:
            print(res)
            break
