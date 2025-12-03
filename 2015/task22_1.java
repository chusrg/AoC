package year2015;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

//       Task: https://adventofcode.com/2015/day/22
// Input Data: https://adventofcode.com/2015/day/22/input
//     Answer: 900
public class task22_1 {
    private static final List<String> lines = new ArrayList<>();
    private static int calc() {
        int min = Integer.MAX_VALUE;
        int N = 100000;
        Random r = new Random();

        for (int i = 0; i < N; i++) {
            int cost = 0, magicNo;
            int   playerHP = 50,
                playerMana = 500;

            int     bossHP = Integer.parseInt(lines.get(0).split(": ")[1]),
                bossDamage = Integer.parseInt(lines.get(1).split(": ")[1]);

            int shieldCount = 0, poisonCount = 0, rechargeCount = 0;

            for (int j = 0; j < N; j++) {
                if (playerHP <= 0) {
                    cost = Integer.MAX_VALUE;
                    break;
                }

                if (shieldCount > 0) shieldCount--;
                if (poisonCount-- > 0) bossHP -= 3;
                if (rechargeCount-- > 0) playerMana += 101;
                if (bossHP <= 0) break;


                do {
                    magicNo = r.nextInt(5);
                } while ((magicNo == 2 && shieldCount > 0) || (magicNo == 3 && poisonCount > 0) || (magicNo == 4 && rechargeCount > 0));

                switch (magicNo) {
                    case 0: {
                        cost += 53;
                        playerMana -= 53;
                        bossHP -= 4;
                    }
                    break;

                    case 1: {
                        cost += 73;
                        playerMana -= 73;
                        bossHP -= 2;
                        playerHP += 2;
                    }
                    break;

                    case 2: {
                        cost += 113;
                        playerMana -= 113;
                        shieldCount = 6;
                    }
                    break;

                    case 3: {
                        cost += 173;
                        playerMana -= 173;
                        poisonCount = 6;
                    }
                    break;

                    case 4: {
                        cost += 229;
                        playerMana -= 229;
                        rechargeCount = 5;
                    }
                    break;
                }

                if (playerMana <= 0) {
                    cost = Integer.MAX_VALUE;
                    break;
                }

                if (bossHP <= 0) break;
                if (poisonCount-- > 0) bossHP -= 3;
                if (rechargeCount-- > 0) playerMana += 101;
                if (bossHP <= 0) break;

                if (shieldCount > 0) {
                    playerHP -= ((bossDamage - 7) <= 0) ? 1 : (bossDamage - 7);
                    shieldCount--;
                } else {
                    playerHP -= bossDamage;
                }

                if (playerMana <= 0) {
                    cost = Integer.MAX_VALUE;
                    break;
                }
            }

            if (cost < min) {
                min = cost;
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