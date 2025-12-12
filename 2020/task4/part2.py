# Answer: 175
import re

input_data = "input"

with (open(input_data, "r", encoding="utf-8") as f):
    count = 0

    data = f.read().strip()
    groups = data.split("\n\n")

    for g in groups:
        gd = dict(a.split(":") for a in [x for x in g.replace("\n"," ").split(" ")])

        if not all(k in gd for k in ["byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"]):
            continue

        byr = gd.get("byr")
        if byr is None or not byr.isdigit() or not (1920 <= int(byr) <= 2002):
            continue

        iyr = gd.get("iyr")
        if iyr is None or not iyr.isdigit() or not (2010 <= int(iyr) <= 2020):
            continue

        eyr = gd.get("eyr")
        if eyr is None or not eyr.isdigit() or not (2020 <= int(eyr) <= 2030):
            continue

        if gd.get("hgt") is None:
            continue

        hgt = gd.get("hgt")
        if hgt is None:
            continue

        if hgt.endswith("cm"):
            try:
                num = int(hgt[:-2])
            except ValueError:
                continue
            if not (150 <= num <= 193):
                continue
        elif hgt.endswith("in"):
            try:
                num = int(hgt[:-2])
            except ValueError:
                continue
            if not (59 <= num <= 76):
                continue
        else:
            continue

        hcl = gd.get("hcl")
        if hcl is None or not re.fullmatch(r"#[0-9a-f]{6}", hcl):
            continue

        ecl = gd.get("ecl")
        if ecl is None or ecl not in ("amb", "blu", "brn", "gry", "grn", "hzl", "oth"):
            continue

        pid = gd.get("pid")
        if pid is None or len(pid) != 9 or not pid.isdigit():
            continue

        count += 1

    print(count)