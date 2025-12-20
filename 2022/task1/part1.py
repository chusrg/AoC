# Answer: 70296
input_data = "input"

with (open(input_data, "r", encoding="utf-8") as f):
    data = f.read().split("\n\n")

    print(max([sum(n) for n in [list(map(lambda x: int(x), s)) for s in [x.split("\n") for x in data]]]))