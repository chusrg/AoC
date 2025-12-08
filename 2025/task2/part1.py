# Answer: 38310256125
input_data = "input"

with (open(input_data, "r", encoding="utf-8") as f):
    sum = 0

    for r in f.read().rstrip("\n").split(','):
        bound_from, bound_to = r.split('-')[0], r.split('-')[1]
        len_from, len_to = len(bound_from), len(bound_to)
        full_num = lambda a,b,l: a * pow(10, l) + b

        if len_from % 2 == 1 and len_to % 2 == 1:
            continue

        if len_from % 2 == 1:
            bound_from = '1' + '0' * len_from

        if len_to % 2 == 1:
            bound_to = '9' * (len_to - 1)

        half_len = len(bound_from) // 2
        a1, a2, b1, b2 = int(bound_from[0:half_len]), int(bound_from[half_len:2 * half_len]), int(
            bound_to[0:half_len]), int(bound_to[half_len:2 * half_len])

        low_bound, high_bound = full_num(a1, a2, half_len), full_num(b1, b2, half_len)
        if low_bound > high_bound:
            continue

        if a1 != a2:
            if a1 < a2:
                a1 += 1
                a2 = a1
            else:
                a2 = a1

        if b1 != b2:
            if b1 < b2:
                b2 = b1
            else:
                b1 -= 1
                b2 = b1

        low_bound, high_bound = full_num(a1, a2, half_len), full_num(b1, b2, half_len)

        if low_bound > high_bound:
            continue

        for n in range(0, b2 - a1 + 1):
            sum += full_num(a1 + n, a1 + n, half_len)
    print(sum)
