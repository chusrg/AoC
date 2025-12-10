# Answer: 513
input_data = "input"

with (open(input_data, "r", encoding="utf-8") as f):
    count, ranges, values, isRanges = 0, [], [], True

    for line in f:
        line = line.rstrip("\n")
        if line == "":
            isRanges = False
            continue

        if isRanges:
            a, b = [int(x) for x in line.split('-')]
            ranges.append((a, b))
        else:
            values.append(int(line))

    for val in values:
        isInclude = False

        for r in ranges:
            if r[0] <= val <= r[1]:
                isInclude = True
                break
        count += isInclude

    print(count)