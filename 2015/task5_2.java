package year2015;

import java.util.Scanner;

//       Task: https://adventofcode.com/2015/day/5
// Input Data: https://adventofcode.com/2015/day/5/input
//     Answer: 51
public class task5_2 {
    private static int calc(final String str) {
        boolean flag = false;
        for (int i = 2; i < str.length(); ++i) {
            if (str.charAt(i) == str.charAt(i - 2)) {
                flag = true;
                break;
            }
        }
        if (!flag) return 0;

        for (int i = 2; i < str.length(); ++i)
            for (int j = i; j < str.length() - 1; j++)
                if (str.charAt(i - 2) == str.charAt(j) && str.charAt(i - 1) == str.charAt(j + 1)) {
                    return 1;
                }

        return 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int sum = 0;
        do {
            sum += calc(str);
            str = in.nextLine().trim();
        } while (!"EOF".equals(str));

        System.out.println(sum);
    }
}
