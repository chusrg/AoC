# Answer: 260
import re

input_data = "input"

with open(input_data, "r", encoding="utf-8") as f:
    count = 0
    for line in f:
        IPv7 = line.rstrip("\n")
        IPv7_reduce = re.sub(r"\[\w+\]", "", IPv7)
        is_inside, n = False, 0

        for i in range(0, len(IPv7)):
            ch = IPv7[i]

            if ch == '[':
                is_inside = True
                continue

            if ch == ']':
                is_inside = False
                continue

            if is_inside and (i - 1 >= 0 and i + 1 < len(IPv7)) and IPv7[i - 1] == IPv7[i + 1] and IPv7[i - 1] != IPv7[i]:
                bab = "".join([IPv7[i], IPv7[i - 1], IPv7[i]])
                if IPv7.find(bab) != -1 and IPv7_reduce.find(bab) != -1:
                    count += 1
                    break

    print(count)
