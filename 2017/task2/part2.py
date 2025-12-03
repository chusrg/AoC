# Answer: 261

input_data = "input"

with open(input_data, "r", encoding="utf-8") as f:
    crc = 0
    for line in f:
        nums = [int(x) for x in line.split('\t')]
        for i in range(0,len(nums)):
            for j in range(0,len(nums)):
                if i != j and nums[i] % nums[j] == 0:
                    crc += nums[i] // nums[j]

    print(crc)
