# Answer: 598

input_data = "input"

with (open(input_data, "r", encoding="utf-8") as f):
    a, b = [int(num) for num in f.read().split('-')]
    double = ["11", "22", "33", "44", "55", "66", "77", "88", "99"]
    count = 0

    for pswd in range(a, b + 1):
        p = str(pswd)
        flag = False

        for d in double:
            pos = p.find(d)
            if pos != -1:
                if ((pos-1 >= 0 and p[pos-1] != d[0]) or (pos == 0)) \
                    and ((pos+2 < len(p) and p[pos+2] != d[0]) or (pos == len(p)-2)):
                    flag = True
                    break

        if flag:
            prev = p[0]
            for i in p:
                if ord(prev) > ord(i):
                    flag = False
                    break
                prev = i

        count += flag

    print(count)
