# Answer: 2180

input_data = "input"

with (open(input_data, "r", encoding="utf-8") as f):
    lines = f.read()

    cable1 = [tuple([x[0], x[1:]]) for x in lines.split("\n")[0].split(",")]
    cable2 = [tuple([x[0], x[1:]]) for x in lines.split("\n")[1].split(",")]

    dir = {"U": (0, 1),
           "D": (0, -1),
           "L": (-1, 0),
           "R": (1, 0)}

    path = dict()
    crossing = set()
    point = (0, 0) # central port
    for p in cable1:
        for i in range(0, int(p[1])):
            point = tuple(x + y for x, y in zip(point, dir[p[0]]))
            if path.get(point) == None:
                path[point] = 1

    point = (0, 0) # central port
    for p in cable2:
        for i in range(0, int(p[1])):
            point = tuple(x + y for x, y in zip(point, dir[p[0]]))
            if path.get(point) != None:
                crossing.add(point)

    print(min(list(map(lambda x: abs(x[0]) + abs(x[1]), crossing))))