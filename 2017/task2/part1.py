# Answer: 36766

input_data = "input"

with open(input_data, "r", encoding="utf-8") as f:
    crc = 0
    for line in f:
        nums = [int(x) for x in line.split('\t')]
        crc += max(nums) - min(nums)

    print(crc)
