package year2015;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//         Task: https://adventofcode.com/2015/day/18
//   Input Data: https://adventofcode.com/2015/day/18/input
// Answer task1: 1061   (default)
// Answer task2: 601    (uncomment line 13)
public class task18_1_2 {
    private static int getNext(int[][] map, int i, int j, int sizeX, int sizeY) {
        if ( (i == 1 || i == sizeX) && (j == 1 || j == sizeY) ) return 1;
        int on = map[i + 1][j + 1] + map[i + 1][j - 1] + map[i + 1][j] + map[i - 1][j - 1] +
                map[i - 1][j + 1] + map[i - 1][j] + map[i][j + 1] + map[i][j - 1];

        if (map[i][j] == 1) return (on == 2 || on == 3) ? 1 : 0;
        return on == 3 ? 1 : 0;
    }

    private static long calc(List<String> conf, int N) {

        int[][] orig = new int[conf.size() + 2][conf.get(0).length() + 2];
        for (int i = 0; i < conf.size(); ++i) {
            for (int j = 0; j < conf.get(i).length(); ++j) {
                orig[i + 1][j + 1] = conf.get(i).charAt(j) == '#' ? 1 : 0;
            }
        }

        while (N-->0) {
            int[][] copy = new int[conf.size() + 2][conf.get(0).length() + 2];
            for (int i = 0; i < conf.size(); ++i) {
                for (int j = 0; j < conf.get(i).length(); ++j) {
                    copy[i + 1][j + 1] = getNext(orig, i + 1, j + 1, conf.size(), conf.get(0).length());
                }
            }
            orig = copy;
        }

        int count = 0;
        for (int i = 0; i < conf.size(); ++i)
            for (int j = 0; j < conf.get(i).length(); ++j) count += orig[i + 1][j + 1];

        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> map = new ArrayList<>();
        String str = in.nextLine();

        while (!"EOF".equals(str)) {
            map.add(str);
            str = in.nextLine();
        }

        System.out.println(calc(map, 100));
    }
}
