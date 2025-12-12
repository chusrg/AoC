# Answer: 32858450
input_data = "input"

with open(input_data, "r", encoding="utf-8") as f:
    mul, nums = 0, []

    for line in f:
        nums.append(int(line.rstrip("\n")))

    for i in range(0,len(nums)):
        flag = False
        for j in range(i,len(nums)):
            for k in range(j,len(nums)):
                if nums[i] + nums[j] + nums[k] == 2020:
                    mul = nums[i] * nums[j] * nums[k]
                    flag = True
                    break
            if flag:
                break

        if flag:
            break

    print(mul)
