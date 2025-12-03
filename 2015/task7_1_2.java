package year2015;

import java.util.*;

//         Task: https://adventofcode.com/2015/day/7
//   Input Data: https://adventofcode.com/2015/day/7/input
// Answer task1: 956    (default)
// Answer task2: 40149  (uncomment line 33)
public class task7_1_2 {

    private static final List<StringBuilder> list = new ArrayList<>();
    private static final Map<String, String> map = new HashMap<>();
    private static int calc() {
        StringBuilder expr;
        String str;
        int idx;

        while (list.size() > 2) {
            // select and remove
            idx = 0;
            while (idx < list.size()) {
                str = list.get(idx).toString();
                if (str.length() != 0 && str.matches(" ?\\d+ -> \\w+")) {
                    String[] data = str.split("->");
                    map.put(data[1] + " ", data[0]);

                    list.remove(idx);
                    continue;
                }
                idx++;
            }

            //map.put(" b " ," 956 ");  // uncomment to solve task2!

            // replace
            for (int i = 0; i < list.size(); ++i) {
                expr = list.get(i);
                if (expr.length() != 0)
                    for (String key : map.keySet()) {
                        if ((idx = expr.indexOf(key)) != -1)
                            expr.replace(idx, idx + key.length(), map.get(key));
                    }
            }
            map.clear();

            // calc
            for (StringBuilder stringBuilder : list) {
                str = stringBuilder.toString();
                if (str.length() != 0 && (str.matches(" \\d+ \\w+ \\d+ -> \\w+") || str.matches(" \\w+ \\d+ -> \\w+"))) {
                    String[] data = str.trim().split(" -> ");
                    String[] lexpr = data[0].split(" ");
                    if (str.contains("NOT")) {
                        stringBuilder.setLength(0);
                        stringBuilder.append(String.format(" %d -> %s", 0xFFFF & (~Integer.parseInt(lexpr[1])), data[1]));
                    } else {
                        int a = Integer.parseInt(lexpr[0]), b = Integer.parseInt(lexpr[2]), c = 0;

                        switch (lexpr[1]) {
                            case "OR":
                                c = a | b;
                                break;
                            case "AND":
                                c = a & b;
                                break;
                            case "LSHIFT":
                                c = a << b;
                                break;
                            case "RSHIFT":
                                c = a >> b;
                                break;
                        }

                        stringBuilder.setLength(0);
                        stringBuilder.append(String.format(" %d -> %s", c, data[1]));
                    }
                }
            }
        }

        for (StringBuilder s : list) {
            if (s.toString().contains(" -> a")) {
                return Integer.parseInt(s.toString().replaceAll(" -> a", "").trim());
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        while (!"EOF".equals(str)) {
            list.add(new StringBuilder(" "+str));
            str = in.nextLine().trim();
        }
        System.out.println(calc());
    }
}