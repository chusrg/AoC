# Answer: 4556
input_data = "input"

with (open(input_data, "r", encoding="utf-8") as f):
    org_seq = f.read().rstrip("\n")
    min_len = len(org_seq)

    for p in range(0, ord('z') - ord('a')):
        ch1, ch2 = chr(ord('a') + p), chr(ord('A') + p)
        seq = org_seq
        seq = seq.replace(ch1, "").replace(ch2, "")

        flag, pos = True, 0
        while flag:
            flag = False
            for i in range(pos, len(seq) - 1):
                if seq[i] != seq[i + 1] and seq[i].upper() == seq[i + 1].upper():
                    seq = seq[:i] + seq[i + 2:]
                    pos = 0 if i == 0 else i - 1
                    flag = True
                    break

        if len(seq) < min_len:
            min_len = len(seq)

    print(min_len)
