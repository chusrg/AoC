# Answer: 339668510830757
input_data = "input"

with (open(input_data, "r", encoding="utf-8") as f):
    count, org_ranges, new_ranges = 0, [], []

    for line in f:
        line = line.rstrip("\n")
        if line == "":
            break

        a, b = [int(x) for x in line.split('-')]
        org_ranges.append((a,b))

    org_ranges.sort(reverse=False)

    ranges_wo_d = org_ranges

    for i in range(0, len(ranges_wo_d) - 1):
        if ranges_wo_d[i][1] == ranges_wo_d[i + 1][1] and ranges_wo_d[i][0] == ranges_wo_d[i + 1][0]:
            ranges_wo_d[i] = (0, 0)

    for i in range(0, len(ranges_wo_d) - 1):
        if ranges_wo_d[i][0] == ranges_wo_d[i + 1][0]:
            ranges_wo_d[i + 1] = (ranges_wo_d[i + 1][0], max(ranges_wo_d[i][1], ranges_wo_d[i + 1][1]))
            ranges_wo_d[i] = (0, 0)

    for i in range(0, len(ranges_wo_d) - 1):
        if ranges_wo_d[i][1] == ranges_wo_d[i + 1][1]:
            ranges_wo_d[i + 1] = (min(ranges_wo_d[i][0], ranges_wo_d[i + 1][0]), ranges_wo_d[i + 1][1])
            ranges_wo_d[i] = (0, 0)

    for i in range(0, len(ranges_wo_d)):
        if ranges_wo_d[i][0] != 0:
            new_ranges.append(ranges_wo_d[i])

    i, org_ranges, flag = 0, [], True
    while flag:
        flag = False
        while i < len(new_ranges) - 1:
            if new_ranges[i][1] > new_ranges[i + 1][0]:
                new_ranges[i + 1] = (min(new_ranges[i][0],new_ranges[i+1][0]), max(new_ranges[i][1],new_ranges[i+1][1]))
                new_ranges[i] = (0, 0)
                flag = True
                org_ranges = []

                for t in new_ranges:
                    if t != (0,0):
                        org_ranges.append(t)

                new_ranges = org_ranges
                break
            i += 1

    for i in range(0, len(new_ranges)):
        count += new_ranges[i][1] - new_ranges[i][0] + 1

    n = 1
    for i in range(0, len(new_ranges)):
        if new_ranges[i][0] == new_ranges[i][1]:
            n += 1

    print(count-n)