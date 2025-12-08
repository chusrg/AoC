# Answer: 910

input_data = "input"

with (open(input_data, "r", encoding="utf-8") as f):
    a, b = [int(num) for num in f.read().split('-')]
    double = ["11", "22", "33", "44", "55", "66", "77", "88", "99"]
    count = 0

    for pswd in range(a, b + 1):
        p = str(pswd)

        flag = False
        for d in double:
            if p.find(d) != -1:
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
