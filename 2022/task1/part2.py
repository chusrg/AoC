# Answer: 205381
input_data = "input"

with (open(input_data, "r", encoding="utf-8") as f):
    data = f.read().split("\n\n")

    all_bags = [sum(n) for n in [list(map(lambda x: int(x), s)) for s in [x.split("\n") for x in data]]]
    print(sum(sorted(all_bags, reverse=True)[:3]))
