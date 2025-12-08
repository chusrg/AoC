# Answer: c6697b55

input_data = "input"

import hashlib

with open(input_data, "r", encoding="utf-8") as f:

    door_id = f.read().rstrip("\n")

    password = ""
    index = 0

    while len(password) < 8:
        to_hash = (door_id + str(index)).encode('utf-8')
        h = hashlib.md5(to_hash).hexdigest()
        if h.startswith("00000"):
            password += h[5]
        index += 1

    print(password)
