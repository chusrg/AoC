# Answer: 112316

input_data = "input"

with (open(input_data, "r", encoding="utf-8") as f):
    lines = f.read()

    cable1 = [tuple([x[0], x[1:]]) for x in lines.split("\n")[0].split(",")]
    cable2 = [tuple([x[0], x[1:]]) for x in lines.split("\n")[1].split(",")]

    dir = {"U": (0, 1),
           "D": (0, -1),
           "L": (-1, 0),
           "R": (1, 0)}

    dist1, dist2, path, crossing = dict(), dict(), dict(), set()

    point, d1 = (0, 0), 0
    for p in cable1:
        for i in range(0, int(p[1])):
            point = tuple(x + y for x, y in zip(point, dir[p[0]]))
            d1 += 1

            if path.get(point) == None:
                path[point] = 1

            if dist1.get(point) == None:
                dist1[point] = d1

    point, d2 = (0, 0), 0
    for p in cable2:
        for i in range(0, int(p[1])):
            point = tuple(x + y for x, y in zip(point, dir[p[0]]))
            d2 += 1

            if path.get(point) != None:
                crossing.add(point)

            if dist2.get(point) == None:
                dist2[point] = d2

    print(min(list(map(lambda x: dist1[x]+dist2[x], crossing))))