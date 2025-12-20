# Answer: 1195
input_data = "input"

with (open(input_data, "r", encoding="utf-8") as f):
    count = 0

    data = f.read().strip()
    nums = [int(x) for x in data.split("\n")]

    prev = nums[0]
    for i in range(1, len(nums)):
        if nums[i] > prev:
            count += 1

        prev = nums[i]

    print(count)