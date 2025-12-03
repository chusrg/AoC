package year2015;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//             Task: https://adventofcode.com/2015/day/23
//       Input Data: https://adventofcode.com/2015/day/23/input
//     Answer task1: 184 (default)
//     Answer task2: 231 (uncomment line 13)
public class task23_1_2 {
    private static long calc(List<String> lines) {
        int a = 0, // a = 1
            b = 0, idx = 0;
        while (idx != lines.size()) {
            String s = lines.get(idx);
            String[] cmd = s.split(" ");
            switch (cmd[0]) {
                case "hlf":
                    if (cmd[1].charAt(0) == 'a') a /= 2;
                    else b /= 2;
                    break;

                case "tpl":
                    if (cmd[1].charAt(0) == 'a') a *= 3;
                    else b *= 3;
                    break;

                case "inc":
                    if (cmd[1].charAt(0) == 'a') a += 1;
                    else b += 1;
                    break;

                case "jmp": {
                    if (cmd[1].charAt(0) == '-') {
                        idx -= Integer.parseInt(cmd[1].substring(1));
                    } else {
                        idx += Integer.parseInt(cmd[1].substring(1));
                    }
                }
                continue;

                case "jie":
                    if ((cmd[1].charAt(0) == 'a' && a % 2 == 0) || (cmd[1].charAt(0) == 'b' && b % 2 == 0)) {
                        if (cmd[2].charAt(0) == '-') {
                            idx -= Integer.parseInt(cmd[2].substring(1));
                        } else {
                            idx += Integer.parseInt(cmd[2].substring(1));
                        }
                        continue;
                    }
                    break;

                case "jio":
                    if ((cmd[1].charAt(0) == 'a' && a == 1) || (cmd[1].charAt(0) == 'b' && b == 1)) {
                        if (cmd[2].charAt(0) == '-') {
                            idx -= Integer.parseInt(cmd[2].substring(1));
                        } else {
                            idx += Integer.parseInt(cmd[2].substring(1));
                        }
                        continue;
                    }
                    break;
            }
            ++idx;
        }
        return b;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final List<String> lines = new ArrayList<>();
        String str = in.nextLine();

        while (!"EOF".equals(str)) {
            if (!str.isEmpty()) {
                lines.add(str);
            }
            str = in.nextLine().trim();
        }

        System.out.println(calc(lines));
    }
}
