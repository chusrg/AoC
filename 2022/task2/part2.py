# Answer: 13433
input_data = "input"

with (open(input_data, "r", encoding="utf-8") as f):
    score, score_map = 0, {
        'AX': 3,
        'AY': 4,
        'AZ': 8,
        'BX': 1,
        'BY': 5,
        'BZ': 9,
        'CX': 2,
        'CY': 6,
        'CZ': 7
    }

    for line in f:
        val = line.strip().replace(" ", "")
        score += score_map[val]

    print(score)