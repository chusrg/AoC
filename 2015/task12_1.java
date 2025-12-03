package year2015;

import java.util.Scanner;

//       Task: https://adventofcode.com/2015/day/12
// Input Data: https://adventofcode.com/2015/day/12/input
//     Answer: 119433
public class task12_1 {

    private static int calc(final String str) {
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        int sum = 0;

        for (int i = 0; i < str.length(); ++i) {
            char ch = str.charAt(i);

            if ( ch == '-' || Character.isDigit(ch))
            {
                if ( !flag ) {
                    flag = true;
                    sb.setLength(0);
                    sb.append(ch);
                } else {
                    sb.append(ch);
                }
            }
            else
            {
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
        String str = in.nextLine();
        int sum = 0;

        while (!"EOF".equals(str)) {
            sum += calc(str);
            str = in.nextLine().trim();
        }

        System.out.println(sum);
    }
}
