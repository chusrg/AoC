# Answer: 542619
input_data = "input"

with open(input_data, "r", encoding="utf-8") as f:
    mul, nums = 0, []

    for line in f:
        nums.append(int(line.rstrip("\n")))

    for i in range(0,len(nums)):
        flag = False
        for j in range(i,len(nums)):
            if nums[i] + nums[j] == 2020:
                mul = nums[i] * nums[j]
                flag = True
                break
        if flag:
            break

    print(mul)
