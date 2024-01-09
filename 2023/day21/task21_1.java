package year2023;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//       Task: https://adventofcode.com/2023/day/21
// Input Data: https://adventofcode.com/2023/day/21/input
//     Answer: 3632
public class task21_1 {
    private static void set(char[][] map, int i, int j, char ch) {
        if (i >= 0 && i < map.length && j >= 0 && j < map[0].length && map[i][j] != '#') map[i][j] = ch;
    }

    private static void transform(char[][] map, char srcChar, char targetChar, int cnt, int goal) {
        if (cnt >= goal) {
            return;
        }

        for (int i = 0; i < map.length; ++i) {
            for (int j = 0; j < map[0].length; ++j)
                if (map[i][j] == srcChar) {
                    set(map, i, j + 1, targetChar);
                    set(map, i, j - 1, targetChar);
                    set(map, i + 1, j, targetChar);
                    set(map, i - 1, j, targetChar);
                    map[i][j] = '.';
                }
        }

        transform(map, targetChar, srcChar, cnt + 1, goal);
    }

    private static int calc(List<String> lines, int N) {
        char[][] map = new char[lines.size()][lines.get(0).length()];
        for (int i = 0; i < lines.size(); ++i) {
            System.arraycopy(lines.get(i).toCharArray(), 0, map[i], 0, lines.get(i).length());
        }

        transform(map, 'S', 'O', 0, N);

        int count = 0;
        for (char[] chars : map) {
            for (int j = 0; j < map[0].length; ++j)
                if (chars[j] == (N % 2 == 0 ? 'S' : 'O')) ++count;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final List<String> lines = new ArrayList<>();
        String str = in.nextLine();

        while (!"EOF".equals(str)) {
            if (!str.isEmpty()) {
                lines.add(str);
            }
            str = in.nextLine().trim();
        }
        System.out.println(calc(lines,64));
    }
}
