package year2015;

import java.util.Scanner;

//       Task: https://adventofcode.com/2015/day/6
// Input Data: https://adventofcode.com/2015/day/6/input
//     Answer: 15343601
public class task6_2 {

    private static void calc(int[][] map, final String str) {
        String[] data = str.replaceAll(" off", "off")
                .replaceAll(" on", "on")
                .replaceAll(" through ", " ")
                .split(" ");

        String[] from = data[1].split(",");
        String[] to = data[2].split(",");

        int mode = 2;
        switch (data[0]) {
            case "turnon":
                mode = 1;
                break;
            case "turnoff":
                mode = -1;
                break;
        }

        int     x0 = Integer.parseInt(from[0]),
                y0 = Integer.parseInt(from[1]),
                x1 = Integer.parseInt(to[0]),
                y1 = Integer.parseInt(to[1]);

        for (int i = x0; i <= x1; ++i)
            for (int j = y0; j <= y1; ++j) {
                if (mode == -1) {
                    map[i][j] = (map[i][j] == 0) ? 0 : map[i][j] - 1;
                } else {
                    map[i][j] += mode;
                }
            }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        final int SIZE = 1000;
        int[][] map = new int[SIZE][SIZE];
        int sum = 0;

        while (!"EOF".equals(str)) {
            calc(map, str);
            str = in.nextLine().trim();
        }

        for (int i = 0; i < SIZE; ++i)
            for (int j = 0; j < SIZE; ++j) sum += map[i][j];

        System.out.println(sum);
    }
}
