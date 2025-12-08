# Answer: gyvwpxaz

input_data = "input"

with open(input_data, "r", encoding="utf-8") as f:
    freq = []
    is_first = True
    for line in f:
        line = line.rstrip("\n")

        if is_first:
            is_first = False
            for i in range(0, len(line)):
                freq.append(dict())

        for i in range(0, len(line)):
            if freq[i].get(line[i]) == None:
                freq[i][line[i]] = 1
            else:
                freq[i][line[i]] += 1

    signal = ""
    for i in range(0, len(line)):
        first_key, first_value = max(freq[i].items(), key=lambda item: item[1])
        signal += first_key

    print(signal)