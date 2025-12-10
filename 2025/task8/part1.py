# Answer: 117000
input_data = "input"
import math

# Количество соединяемых пар
K = 1000

class DSU:
    def __init__(self, n):
        self.parent = list(range(n))
        self.size = [1] * n

    def find(self, x):
        while self.parent[x] != x:
            self.parent[x] = self.parent[self.parent[x]]
            x = self.parent[x]
        return x

    def union(self, a, b):
        ra = self.find(a)
        rb = self.find(b)
        if ra == rb:
            return False
        if self.size[ra] < self.size[rb]:
            ra, rb = rb, ra
        self.parent[rb] = ra
        self.size[ra] += self.size[rb]
        return True

def main():
    points = []
    with open('input', 'r') as f:
        for line in f:
            line = line.strip()
            if not line:
                continue
            x_str, y_str, z_str = line.split(',')
            x, y, z = map(int, (x_str, y_str, z_str))
            points.append((x, y, z))

    n = len(points)
    if n == 0:
        print(0)
        return

    # Строим список всех пар (i, j, distance)
    edges = []
    for i in range(n):
        x1, y1, z1 = points[i]
        for j in range(i + 1, n):
            x2, y2, z2 = points[j]
            dx = x1 - x2
            dy = y1 - y2
            dz = z1 - z2
            dist = math.sqrt(dx * dx + dy * dy + dz * dz)
            edges.append((dist, i, j))

    # Сортируем по расстоянию
    edges.sort(key=lambda e: e[0])

    dsu = DSU(n)
    connections_made = 0

    # Соединяем K кратчайших (по мере просмотра)
    for dist, i, j in edges:
        if connections_made >= K:
            break
        # Пытаемся объединить компоненты
        merged = dsu.union(i, j)
        # Независимо от того, были ли уже в одной компоненте,
        # по условию "подключить 1000 пар" обычно трактуется
        # как именно 1000 попыток соединения кратчайших пар.
        # Если нужно учитывать только фактические слияния
        # компонент, замените условие ниже:
        connections_made += 1

    # Считаем размеры компонент
    comp_sizes = {}
    for v in range(n):
        root = dsu.find(v)
        comp_sizes[root] = comp_sizes.get(root, 0) + 1

    sizes = sorted(comp_sizes.values(), reverse=True)
    # Если точек меньше 3 компонент, недостающие считаем размером 1
    while len(sizes) < 3:
        sizes.append(1)

    answer = sizes[0] * sizes[1] * sizes[2]
    print(answer)

if __name__ == "__main__":
    main()