# Answer: vmpywg
input_data = "input"

with open(input_data, encoding="utf-8") as f:
    empty_nodes, holder_nodes = set(), []

    for line in f:
        line = line.strip()

        if "->" in line:
            left, right = line.split("->")
            children = [x.strip() for x in right.split(",")]
        else:
            left = line
            children = []

        name, weight = left.split()
        weight = int(weight.strip("()"))

        if len(children) == 0:
            empty_nodes.add(name)
        else:
            holder_nodes.append([name, children])

    while len(holder_nodes) > 1:
        for node in holder_nodes:
            node[1] = [x for x in node[1] if x not in empty_nodes]

        empty_nodes, holder_nodes_new = [], []
        for node in holder_nodes:
            if node[1] == []:
                empty_nodes.append(node[0])
            else:
                holder_nodes_new.append(node)
        holder_nodes = holder_nodes_new

    print(holder_nodes[0][0])
