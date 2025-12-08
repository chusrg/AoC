# Answer: 8c35d1ab

input_data = "input"

import hashlib

with open(input_data, "r", encoding="utf-8") as f:

    door_id = f.read().rstrip("\n")

    password = [' ',' ',' ',' ',' ',' ',' ',' ']
    SIZE = len(password)
    index = 0

    try:
        while password.index(" ") != -1:
            to_hash = (door_id + str(index)).encode('utf-8')
            h = hashlib.md5(to_hash).hexdigest()
            if h.startswith("00000"):
                pos = int(ord(h[5]) - ord('0'))
                if pos < SIZE and password[pos] == ' ':
                    password[pos] = h[6]
                    print(f"hash={h} password=|{password}|")
            index += 1
    except ValueError:
        print("".join(password))
