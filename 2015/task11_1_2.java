package year2015;

import java.util.Scanner;

//         Task: https://adventofcode.com/2015/day/11
//   Input Data: https://adventofcode.com/2015/day/11/input
// Answer task1: hepxxyzz
// Answer task2: heqaabcc
public class task11_1_2 {

    private static StringBuilder next(final StringBuilder str) {
        for (int i = str.length() - 1; i >= 0; --i) {
            if (str.charAt(i) < 'z') {
                str.setCharAt(i, (char) (str.charAt(i) + 1));
            } else {
                while (i >= 0 && str.charAt(i) == 'z') {
                    str.setCharAt(i, 'a');
                    i--;
                }
                str.setCharAt(i, (char) (str.charAt(i) + 1));
            }
            return str;
        }
        return str;
    }

    private static boolean check(final StringBuilder str) {
        boolean flag = false;

        // 2) not i, j
        for (char ch : "ij".toCharArray()) {
            int pos = str.indexOf(String.valueOf(ch));
            if (pos != -1) {
                str.setCharAt(pos, 'k');
                for (int i = pos + 1; i < str.length(); ++i)
                    str.setCharAt(i, 'a');
                flag = true;
            }
        }
        if (flag) return false;

        // 1) abd or abc
        flag = false;
        for (int i = 0; i < str.length() - 2; ++i) {
            if (str.charAt(i) == str.charAt(i + 1) - 1 && str.charAt(i + 1) == str.charAt(i + 2) - 1) {
                flag = true;
                break;
            }
        }

        if (!flag && str.indexOf("abd") == -1) return false;


        // 3) xx and yy
        String pair1 = "", pair2 = "";
        for (int i = 0; i < str.length() - 1; ++i) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                if (pair1.isEmpty()) pair1 = String.format("%c%c", str.charAt(i), str.charAt(i + 1));
                else {
                    pair2 = String.format("%c%c", str.charAt(i), str.charAt(i + 1));
                    if (!pair1.equals(pair2)) {
                        return true;
                    }
                }
                ++i;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        StringBuilder str = new StringBuilder(s);
        do {
            next(str);
        }while (!check(str));

        System.out.println(str.toString());
    }
}
