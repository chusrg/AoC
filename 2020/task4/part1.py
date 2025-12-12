# Answer: 228
input_data = "input"

with open(input_data, "r", encoding="utf-8") as f:
    count, data = 0, f.read().strip()

    for g in data.split("\n\n"):
        gs = {x.split(":")[0] for x in g.replace("\n"," ").split(" ")}
        if len(gs) == 8 or (len(gs) == 7 and not ("cid" in gs)):
            count += 1

    print(count)