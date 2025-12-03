package year2015;

import java.util.Scanner;

//       Task: https://adventofcode.com/2015/day/1
// Input Data: https://adventofcode.com/2015/day/1/input
//     Answer: 1795
public class task1_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine().trim();
        int floor = 0;

        for (int i = 0; i < line.length(); ++i) {
            switch (line.charAt(i)) {
                case '(':
                    ++floor;
                    break;
                case ')':
                    --floor;
                    break;
            }

            if (floor == -1) {
                System.out.println(i + 1);
                break;
            }
        }
    }
}
