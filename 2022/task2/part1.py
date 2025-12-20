# Answer: 13484
input_data = "input"

with (open(input_data, "r", encoding="utf-8") as f):
    score, score_map = 0, {
        'AX': 4,
        'AY': 8,
        'AZ': 3,
        'BX': 1,
        'BY': 5,
        'BZ': 9,
        'CX': 7,
        'CY': 2,
        'CZ': 6,
    }

    for line in f:
        val = line.strip().replace(" ", "")
        score += score_map[val]

    print(score)