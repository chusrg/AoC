package year2015;

import java.util.Scanner;

//       Task: https://adventofcode.com/2015/day/12
// Input Data: https://adventofcode.com/2015/day/12/input
//     Answer: 68466
public class task12_2 {

    private static int calc(final StringBuilder str) {
        final String RED_LABEL = ":\"red\"";
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        int sum = 0, pos, count, left, right;

        while ((pos = str.indexOf(RED_LABEL)) != -1) {
            count = 0;
            left = pos;
            right = pos + RED_LABEL.length() - 1;

            while (count != 1 && left != 0) {
                --left;
                switch (str.charAt(left)) {
                    case '{':
                        count += 1;
                        break;
                    case '}':
                        count -= 1;
                        break;
                }
            }

            while (count != 0 && right != str.length() - 1) {
                ++right;
                switch (str.charAt(right)) {
                    case '{':
                        count += 1;
                        break;
                    case '}':
                        count -= 1;
                        break;
                }
            }

            System.out.println(str.substring(left, right + 1));
            str.replace(left, right + 1, "");
        }

        for (int i = 0; i < str.length(); ++i) {
            char ch = str.charAt(i);

            if (ch == '-' || Character.isDigit(ch)) {
                if (!flag) {
                    flag = true;
                    sb.setLength(0);
                    sb.append(ch);
                } else {
                    sb.append(ch);
                }
            } else {
                if (flag) {
                    sum += Integer.parseInt(sb.toString());
                    flag = false;
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder str = new StringBuilder(in.nextLine());
        int sum = 0;

        while (!"EOF".equals(str.toString())) {
            sum += calc(str);
            str = new StringBuilder(in.nextLine());
        }

        System.out.println(sum);
    }
}
