package year2015;

import java.util.*;

//       Task: https://adventofcode.com/2015/day/8
// Input Data: https://adventofcode.com/2015/day/8/input
//     Answer: 2117
public class task8_2 {

    private static int calc(final String str) {
        int count = 2;
        for (int i = 0; i < str.length(); ++i, ++count) {
            switch (str.charAt(i))
            {
                case '\\':
                case '\"':
                    ++count;
                    break;
            }
        }

        return count - str.length();
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