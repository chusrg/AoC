# Answer: 324
input_data = "input"

with open(input_data, "r", encoding="utf-8") as f:
    find_id = -1

    for line in f:
        data = line.rstrip("\n").rsplit("-")
        id, crc = data[-1].rstrip("]").split("[")
        data.pop()
        data = '-'.join(data)

        offset = int(id) % 26

        encrypt_data = ""
        for i in range(0, len(data)):
            if data[i] == '-':
                encrypt_data += ' '
            else:
                encrypt_data += chr(ord('a') + (offset + ord(data[i]) - ord('a')) % 26)

        if encrypt_data.find("north") != -1 and encrypt_data.find("pole") != -1:
            find_id = int(id)
            break

    print(find_id)
