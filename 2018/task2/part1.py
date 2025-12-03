# Answer: 5704

input_data = "input"

with open(input_data, "r", encoding="utf-8") as f:
    count2 = 0
    count3 = 0

    for line in f:
        count = {}

        for ch in line:
            idx = int(ord(ch) - ord('a'))
            count[idx] = (0 if count.get(idx) == None else count[idx]) + 1

        for el in count.values():
            if el == 2:
                count2 += 1
                break

        for el in count.values():
            if el == 3:
                count3 += 1
                break

    print(count2 * count3)
