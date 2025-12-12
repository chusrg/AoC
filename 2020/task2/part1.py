# Answer: 548
input_data = "input"

with open(input_data, "r", encoding="utf-8") as f:
    count = 0

    for line in f:
        r, sym, passwd = line.split()
        sym = sym[0]
        a, b = [int(x) for x in r.split('-')]
        cnt = 0
        for ch in passwd:
            if ch == sym:
                cnt += 1

        if cnt >= a and cnt <= b:
            count += 1

    print(count)