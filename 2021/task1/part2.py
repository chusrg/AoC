# Answer: 1235
input_data = "input"

with (open(input_data, "r", encoding="utf-8") as f):
    count = 0

    data = f.read().strip()
    nums = [int(x) for x in data.split("\n")]

    prev = sum(nums[0:3])
    for i in range(1, len(nums)-2):
        next = sum(nums[i:i+3])
        if next > prev:
            count += 1
        prev = next

    print(count)