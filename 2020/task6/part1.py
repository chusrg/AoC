# Answer: 6457
input_data = "input"

with open(input_data, "r", encoding="utf-8") as f:
    data = f.read().strip()

    groups = data.split("\n\n")

    count = 0
    for group in groups:
        persons = group.splitlines()
        common_yes = set(persons[0])

        for p in persons[1:]:
            common_yes |= set(p)
        count += len(common_yes)

    print(count)