# Answer: 58961152806
input_data = "input"

with (open(input_data, "r", encoding="utf-8") as f):
    invalid_IDs = set()
    isInBound = lambda c, a, b: c >= a and c <= b
    pure_ranges = []

    for r in f.read().rstrip("\n").split(','):
        a, b = r.split('-')[0], r.split('-')[1]
        a_len, b_len = len(a), len(b)

        if a_len == b_len:
            pure_ranges.append((a, b))
        else:
            pure_ranges.append((a, '9' * len(a)))
            pure_ranges.append(('1' + '0' * (len(b) - 1), b))

    for r in pure_ranges:
        for n in range(1,6):
            a, b = r[0], r[1]
            a_len, b_len = len(a), len(b)
            a_val_org, b_val_org = int(a), int(b)

            if a_len % n != 0:
                continue

            k = a_len // n
            if k <= 1:
                break

            pos = 0
            while pos + n < a_len and int(a[pos+0:pos+n]) == int(a[pos+n:pos+n+n]):
                pos += n

                if pos+n+n > a_len:
                    break

                if int(a[pos+0:pos+n]) < int(a[pos+n:pos+n+n]):
                    a = k * str(int(a[0:n]) + 1)
                    break

            if int(a[0:n]) < int(a[n:n+n]):
                a = str(int(a[0:n])+1) + a[n:]

            val_a = int(a[0:n])
            a_val, b_val = int(a), int(b)
            val = int(k * a[0:n])

            while isInBound(val,a_val_org,b_val_org):
                invalid_IDs.add(val)
                val_a += 1
                val = int(k * str(val_a))

    print(sum(invalid_IDs))
