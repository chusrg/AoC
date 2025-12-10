# Answer: 1674
input_data = "input"

class TreeNode:
    def __init__(self, name, weight, childs):
        self.name = name
        self.weight = weight
        self.childs = childs

    def get_name(self):
        return self.get_name

    def get_weight(self):
        return self.weight

    def get_childs(self):
        return self.childs

    def set_childs(self, childs):
        self.childs = childs

    def find_delta(self, mem) -> list:
        if not all(x.weight == self.childs[0] for x in self.childs) if self.childs else True:
            if len(self.childs) != 0:
                mem.append([self.weight, self.childs])
                max_weight, max_node = self.childs[0].weight, self.childs[0]

                for i in range(1, len(self.childs)):
                    if self.childs[i].weight > max_weight:
                        max_weight = self.childs[i].weight
                        max_node = self.childs[i]

                mem = max_node.find_delta(mem)

        return mem

with (open(input_data, encoding="utf-8") as f):
    empty_nodes, holder_nodes, child_dict = [], [], dict()

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
            child_dict[name] = TreeNode(name, weight, [])
        else:
            holder_nodes.append(TreeNode(name, weight, children))

    while len(holder_nodes) > 1:
        new_nodes, new_childs = [], []

        for node in holder_nodes:
            w, flag = [], False

            for child in node.get_childs():
                if isinstance(child, TreeNode):
                    w.append(child)
                else:
                    if child_dict.get(child) != None:
                        w.append(child_dict.get(child))
                    else:
                        new_nodes.append(node)
                        flag = True
                        break

            if not flag:
                node.set_childs(w)
            else:
                new_childs.append(node)

        for node in holder_nodes:
            if all(isinstance(x, TreeNode) for x in node.get_childs()):
                child_dict[node.name] = TreeNode(node.name, sum([x.weight for x in node.childs]) + node.weight, node.childs)

        holder_nodes = new_nodes

    holder_nodes[0].set_childs([child_dict.get(child) for child in holder_nodes[0].get_childs()])

    l = holder_nodes[0].find_delta([])
    N = len(l) - 1
    delta = l[N - 1][0] - len(l[N - 1][1]) * l[N][0] - \
            (max(list(map(lambda x: x.weight, l[0][1]))) - min(list(map(lambda x: x.weight, l[0][1]))))

    print(delta)
