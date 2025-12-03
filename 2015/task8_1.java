package year2015;

import java.util.*;

//       Task: https://adventofcode.com/2015/day/8
// Input Data: https://adventofcode.com/2015/day/8/input
//     Answer: 1371
public class task8_1 {

    private static int calc(final String str) {
        int count = 0;
        for (int i = 1; i < str.length() - 1; ++count) {
            if (str.charAt(i) == '\\') {
                if (str.charAt(i + 1) == 'x') {
                    i += 3;
                } else {
                    i += 1;
                }
            }
            ++i;
        }

        return str.length() - count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int sum = 0;

        while (!"EOF".equals(str)) {
            sum += calc(str);
            str = in.nextLine().trim();
        }

        System.out.println(sum);
    }
}