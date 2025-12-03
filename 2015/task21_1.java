package year2015;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//       Task: https://adventofcode.com/2015/day/21
// Input Data: https://adventofcode.com/2015/day/21/input
//     Answer: 111
public class task21_1 {
    private static final int[][] weapons = {{8, 4, 0}, {10, 5, 0}, {25, 6, 0}, {40, 7, 0}, {74, 8, 0}};
    private static final int[][] armor = {{0, 0, 0}, {13, 0, 1}, {31, 0, 2}, {53, 0, 3}, {75, 0, 4}, {102, 0, 5}};
    private static final int[][] rings = {{0, 0, 0}, {0, 0, 0}, {25, 1, 0}, {50, 2, 0}, {100, 3, 0}, {20, 0, 1}, {40, 0, 2}, {80, 0, 3}};
    private static final List<String> lines = new ArrayList<>();

    private static void init(int[] player, int[] boss, int idx) {
        player[0] = 100;
        player[1] = weapons[idx][1];
        player[2] = weapons[idx][2];

        for (int i = 0; i < 3; i++) {
            boss[i] = Integer.parseInt(lines.get(i).split(": ")[1]);
        }
    }

    private static void add(int[] player, int idx, int[][] obj) {
        player[1] += obj[idx][1];
        player[2] += obj[idx][2];
    }

    private static boolean check(int[] player, int[] boss) {
        int k = 0;
        // Cost  Damage  Armor
        while (boss[0] > 0 && player[0] > 0) {
            if (k++ % 2 == 0)
                boss[0] -= player[1] - boss[2];
            else
                player[0] -= boss[1] - player[2];
        }

        return player[0] > 0;
    }

    private static int calc() {
        int[] boss = new int[3];
        int[] player = new int[3];

        int min = Integer.MAX_VALUE, cost;

        for (int i = 0; i < weapons.length; i++) {
            init(player, boss, i);

            cost = weapons[i][0];
            if (check(player, boss) && cost < min) {
                min = cost;
            }

            for (int j = 0; j < armor.length; j++) {
                init(player, boss, i);
                add(player, j, armor);

                cost = weapons[i][0] + armor[j][0];
                if (check(player, boss) && cost < min) {
                    min = cost;
                }
            }

            for (int k1 = 0; k1 < rings.length; k1++) {
                for (int k2 = 0; k2 < rings.length; k2++) {
                    if (k1 != k2) {
                        for (int j = 0; j < armor.length; j++) {
                            init(player, boss, i);
                            add(player, k1, rings);
                            add(player, k2, rings);
                            add(player, j, armor);

                            cost = weapons[i][0] + rings[k1][0] + rings[k2][0] + armor[j][0];
                            if (check(player, boss) && cost < min) {
                                min = cost;
                            }
                        }
                    }
                }
            }
        }

        return min;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        while (!"".equals(str)) {
            if (!str.isEmpty()) {
                lines.add(str);
            }
            str = in.nextLine().trim();
        }

        System.out.println(calc());
    }
}