package year2015;

import java.util.*;

//       Task: https://adventofcode.com/2015/day/20
// Input Data: https://adventofcode.com/2015/day/20/input
//     Answer: 705600
public class task20_2 {
    private static long calc(int N) {
        int SIZE = N / 10;
        long[] arr = new long[SIZE + 1];

        for (int i = 1; i <= N / 10; ++i) {
            for (int k = 1; k <= 50; ++k) {
                if (k * i > SIZE) break;
                arr[k * i] += i * 11L;
            }
        }

        for (int i = 1; i <= SIZE; i++)
            if (arr[i] >= N) return i;

        return 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        int N = Integer.parseInt(str);
        System.out.println(calc(N));
    }
}
