from collections import defaultdict
import sys

def read_graph(filename: str) -> dict[str, list[str]]:
    graph = defaultdict(list)
    with open(filename, "r", encoding="utf-8") as f:
        for line in f:
            line = line.strip()
            if not line:
                continue
            # формат: node: a b c
            left, right = line.split(":", 1)
            node = left.strip()
            targets = right.split()
            graph[node].extend(targets)
    return graph

def count_paths_with_nodes(graph: dict[str, list[str]],
                           start: str,
                           end: str,
                           must_visit: set[str]) -> int:
    """
    Считает количество различных путей от start до end,
    которые содержат все вершины из must_visit (в любом порядке).
    Узлы не посещаем повторно в одном пути (чтобы избежать циклов).
    """
    count = 0

    def dfs(node: str, visited: set[str], visited_flags: set[str]):
        nonlocal count

        # если дошли до end, проверяем, что все обязательные узлы посещены
        if node == end:
            if must_visit.issubset(visited_flags):
                count += 1
            return

        # идём по всем исходящим рёбрам
        for nxt in graph.get(node, []):
            if nxt in visited:
                # не допускаем повторных посещений узла в одном пути
                continue
            new_visited = visited | {nxt}
            new_flags = visited_flags | ({nxt} & must_visit)
            dfs(nxt, new_visited, new_flags)

    initial_flags = {start} & must_visit
    dfs(start, {start}, initial_flags)
    return count

def main():
    # читаем граф из файла "input"
    filename = "input"
    graph = read_graph(filename)

    start = "svr"
    end = "out"
    must_visit = {"dac", "fft"}

    result = count_paths_with_nodes(graph, start, end, must_visit)
    print(result)

if __name__ == "__main__":
    main()