# Answer: 9154
input_data = "input"

with open(input_data, "r", encoding="utf-8") as f:
    seq = f.read().rstrip("\n")

    flag = True
    pos = 0
    while flag:
        flag = False
        for i in range(pos, len(seq) - 1):
            if seq[i] != seq[i + 1] and seq[i].upper() == seq[i + 1].upper():
                seq = seq[:i] + seq[i + 2:]
                pos = 0 if i == 0 else i-1
                flag = True
                break

    print(len(seq))