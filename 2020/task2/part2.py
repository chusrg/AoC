# Answer: 502
input_data = "input"

with open(input_data, "r", encoding="utf-8") as f:
    count = 0

    for line in f:
        r, sym, passwd = line.split()
        sym = sym[0]
        a, b = [int(x) for x in r.split('-')]

        if ((passwd[a-1] == sym and passwd[b-1] != sym) or (passwd[a-1] != sym and passwd[b-1] == sym)):
            count += 1

    print(count)