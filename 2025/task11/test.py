# Answer:
input_data = "input"

class TreeNode:
    def __init__(self, name, childs):
        self.name = name
        self.childs = childs
        self.visited = False

    def is_visited(self):
        return self.visited

    def do_visited(self):
        self.visited = True

    def get_childs(self):
        return self.childs

    def set_childs(self, childs):
        self.childs = childs

    def find_path(self, node_name: str, is_fft: bool, is_dac: bool, count: int, depth: int, path = list()):
        if self.is_visited():
            return 0

        if self.name in path:
            print("self.do_visited()")
            self.do_visited()
            return 0
        else:
            path.append(self.name)

        # print(f"depth={depth}\t| path={path}")

        if self.name == node_name:
            if is_fft and is_dac:
                return 1
            else:
                return 0
        else:
            if self.name == "fft":
                is_fft = True
            if self.name == "dac":
                is_dac = True

        n = 0
        for child in self.childs:
            path_copy = path.copy()
            n += child.find_path(node_name, is_fft, is_dac, count, depth+1, path_copy)

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
    node = holder_nodes[0].find_node("svr")
    print(node.find_path("fft", False, False, 0, 0))
    # fft
    # dac

    # print(node.find_path("out",False, False, 0, 0))
    # print(node.find_path("out",False, False, 0, 0))
    # print(node.find_path("out",False, False, 0, 0))