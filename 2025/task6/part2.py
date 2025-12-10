# Answer: 10442199710797
input_data = "input"

with (open(input_data, "r", encoding="utf-8") as f):
    result, data = 0, []

    for line in f:
        data.append(line.rstrip("\n"))

    max_len = max([len(x) for x in data])
    for k in range(0, len(data)):
        data[k] = data[k].ljust(max_len, " ")

    start, finish, isRange, l = 0, 0, False, len(data)-1

    for i in range(0, len(data[0])):
        op = ''
        if i+1 == len(data[l]):
            finish, isRange = i+1, True
        elif data[l][i + 1] == '+' or data[l][i + 1] == '*':
            finish, isRange = i, True

        if isRange:
            nums = []
            for j in range(start, finish):
                s = ""
                for k in range(0, l):
                    s += data[k][j]
                nums.append(int(s.strip()))

            r, op = nums[0], data[l][start]
            for j in range(1, len(nums)):
                if op == '+':
                    r += nums[j]
                elif op == '*':
                    r *= nums[j]

            result += r
            isRange, start = False, i+1

    print(result)