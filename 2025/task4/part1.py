# Answer: 1533
input_data = "input"

with open(input_data, "r", encoding="utf-8") as f:
    count, m_size = 0, 0
    lines, pmap = [], []

    for line in f:
        line = line.rstrip("\n")
        lines.append(str('.' + line + '.'))

    m_size = len(lines[0])
    pmap.append(list('.' * m_size))

    for l in lines:
        pmap.append(list(l))
    pmap.append(list('.' * m_size))

    m_size -= 2

    for x in range(1, m_size+1):
        for y in range(1, m_size+1):
            val = 0
            if pmap[x][y] == '@':
                val += 1 if pmap[x][y+1] == '@' else 0
                val += 1 if pmap[x][y-1] == '@' else 0
                val += 1 if pmap[x+1][y] == '@' else 0
                val += 1 if pmap[x+1][y+1] == '@' else 0
                val += 1 if pmap[x+1][y-1] == '@' else 0
                val += 1 if pmap[x-1][y] == '@' else 0
                val += 1 if pmap[x-1][y+1] == '@' else 0
                val += 1 if pmap[x-1][y-1] == '@' else 0

                if val < 4:
                    count += 1

    print(count)
