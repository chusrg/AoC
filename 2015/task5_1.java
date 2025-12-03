package year2015;

import java.util.Scanner;

//       Task: https://adventofcode.com/2015/day/5
// Input Data: https://adventofcode.com/2015/day/5/input
//     Answer: 236
public class task5_1 {
    private static int calc(final String str) {
        if (str.contains("ab") || str.contains("cd") || str.contains("pq") || str.contains("xy")) {
            return 0;
        }

        boolean flag = false;
        for (int i = 1; i < str.length(); ++i) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                flag = true;
                break;
            }
        }
        if (!flag) return 0;

        int count = 0;
        for (int i = 0; i < str.length(); ++i) {
            count += "aeiou".indexOf(str.charAt(i)) != -1 ? 1 : 0;
            if (count == 3) return 1;
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
