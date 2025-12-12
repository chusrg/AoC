# Answer: 786
input_data = "input"

class TreeNode:
    def __init__(self, name, childs):
        self.name = name
        self.childs = childs

    def get_childs(self):
        return self.childs

    def set_childs(self, childs):
        self.childs = childs

    def find_path(self, node_name: str, count: int) -> int:
        if node_name == self.name:
            return 1

        n = 0
        for child in self.childs:
            n += child.find_path(node_name, count)

        return count + n

    def find_node(self, node_name: str):
        if node_name == self.name:
            return self

        for child in self.childs:
            node = child.find_node(node_name)
            if node != None:
                return node

        return None

with (open(input_data, encoding="utf-8") as f):
    empty_nodes, holder_nodes, child_dict = [], [], dict()

    for line in f:
        data = line.split()
        data[0] = data[0].replace(":", "")

        if len(data) == 2:
            if data[1] == "out":
                child_dict[data[0]] = TreeNode("out", [])
            else:
                holder_nodes.append(TreeNode(data[0], [data[1]]))
        else:
            holder_nodes.append(TreeNode(data[0], data[1:]))

    while len(holder_nodes) > 1:
        for node in holder_nodes:
            w = []
            for child in node.get_childs():
                if isinstance(child, TreeNode):
                    w.append(child)
                else:
                    if child_dict.get(child) != None:
                        w.append(child_dict.get(child))
                    else:
                        w.append(child)

            node.set_childs(w)

        new_nodes = []
        for node in holder_nodes:
            if all(isinstance(x, TreeNode) for x in node.get_childs()):
                child_dict[node.name] = node
            else:
                new_nodes.append(node)

        holder_nodes = new_nodes

    holder_nodes[0].set_childs([child_dict.get(child) for child in holder_nodes[0].get_childs()])
    node = holder_nodes[0].find_node("fft")

    print(node.find_path("dac",0))