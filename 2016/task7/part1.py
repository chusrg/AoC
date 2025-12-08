# Answer: 118

input_data = "input"

with open(input_data, "r", encoding="utf-8") as f:

    count = 0
    for line in f:
        IPv7 = line.rstrip("\n")
        is_inside, is_correct, prev, n = False, True, '', 0

        for i in range(0, len(IPv7)):
            ch = IPv7[i]

            if ch == '[':
                is_inside = True
                continue

            if ch == ']':
                is_inside = False
                prev = ''
                continue

            if prev == '':
                prev = ch
                continue
            elif prev == ch and (i-2 >= 0 and i+1 < len(IPv7)) and IPv7[i-2] == IPv7[i+1] and IPv7[i-2] != prev:
                if is_inside:
                    is_correct = False
                    break
                else:
                    n += 1

            prev = ch

        count += (n > 0) and is_correct

    print(count)
