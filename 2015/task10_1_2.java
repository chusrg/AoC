package year2015;

import java.util.Scanner;

//         Task: https://adventofcode.com/2015/day/10
//   Input Data: https://adventofcode.com/2015/day/10/input
// Answer task1: 329356
// Answer task2: 4666278
public class task10_1_2 {

    private static String calc(final String str) {
        StringBuilder sb = new StringBuilder();
        Character ch = str.charAt(0);
        for (int i = 0, count = 0; i < str.length(); ++i) {
            while (i < str.length() && ch == str.charAt(i)) {
                ++i;
                ++count;
            }
            sb.append(count).append(ch);

            if (i >= str.length()) break;

            ch = str.charAt(i);
            if (count != 0) --i;
            count = 0;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        for (int i = 0; i < 40; ++i) {
            str = calc(str);
        }

        System.out.println(str.length());
    }
}
