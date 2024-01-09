package year2023;

import java.text.SimpleDateFormat;
import java.util.*;

//       Task: https://adventofcode.com/2023/day/21
// Input Data: https://adventofcode.com/2023/day/21/input
//     Answer: 600336060511101
public class task21_2 {
    private static final int N = 10000;
    private static final int SIZE = 5 * N + 1;
    private static BitSet[] points = new BitSet[SIZE];
    private static BitSet[] points2 = new BitSet[SIZE];
    private static final Map<Long, Long> tails = new HashMap<>();

    static {
        for (int i = 0; i < SIZE; i++) {
            points[i] = new BitSet(SIZE);
            points2[i] = new BitSet(SIZE);
        }
    }

    private static void set(char[][] map, int i, int j, int goal) {
        int x = getX(map, i);
        int y = getY(map, j);

        if (map[x][y] != '#') {
            points2[i + goal].set(j + goal);
        }
    }

    private static boolean flag = false, oddOReven = false;
    private static long count = 0, BASEcount = 0, PERIOD = 0;
    private static long result = 0;
    private static long valEven = 0, valOdd = 0;
    private static int layer_count = 0;

    private static void transform(char[][] map, int x, int y, int goal) {
        int SZ = map.length, _SZ = map.length / 2;

        for (int i = x * SZ + _SZ; i >= x * SZ - _SZ; --i) {
            for (int j = y * SZ - _SZ; j <= y * SZ + _SZ; ++j) {
                if (points[goal + i].get(goal + j)) {
                    set(map, i, j + 1, goal);
                    set(map, i, j - 1, goal);
                    set(map, i + 1, j, goal);
                    set(map, i - 1, j, goal);
                    points[goal + i].clear(goal + j);
                }
            }
        }
    }

    private static void finish_transform() {
        BitSet[] tmp = points;
        points = points2;
        points2 = tmp;
    }

    private static void solve(char[][] map, int cnt, int goal, int steps) {
        int SZ = map.length;

        if (cnt > steps) {
            result = calcRange(0, 0, goal, goal);
            return;
        }

        if (!flag) {
            for (int i = cnt; i >= -cnt; --i) {
                for (int j = -cnt; j <= cnt; ++j) {
                    if (points[goal + i].get(goal + j)) {
                        set(map, i, j + 1, goal);
                        set(map, i, j - 1, goal);
                        set(map, i + 1, j, goal);
                        set(map, i - 1, j, goal);
                        points[goal + i].clear(goal + j);
                    }
                }
            }

            finish_transform();

            if (cnt == map.length) {
                oddOReven = calcRange(0, 0, 2 * map.length, goal) % 2 == 0;
            }

            if (steps > SZ) {
                valOdd = calcRange(0, 0, map.length, goal);
                valEven = calcRange(0, SZ, map.length, goal);

                long check =
                        calcRange(2 * SZ, 0, map.length, goal) +
                                calcRange(-2 * SZ, 0, map.length, goal) +
                                calcRange(0, 2 * SZ, map.length, goal) +
                                calcRange(0, -2 * SZ, map.length, goal) +
                                calcRange(SZ, SZ, map.length, goal) +
                                calcRange(-SZ, SZ, map.length, goal) +
                                calcRange(SZ, -SZ, map.length, goal) +
                                calcRange(-SZ, -SZ, map.length, goal);

                if (valOdd * 8 == check) {
                    count = cnt + 1;
                    BASEcount = count;
                    flag = true;
                    layer_count = 2;
                    result = valEven + 4 * valOdd + 8 * valEven;
                }
            }
            solve(map, cnt + 1, goal, steps);
        } else {
            long sum = 0;
            final int layers_N = 5; // external layers
            int[][][] perimeters = new int[layers_N][N][2];
            int[] p = new int[layers_N];

            int L = 2;

            long tail = 0;

            while (count < steps) {
                layer_count++;
                for (int k = 0; k < layers_N; ++k)
                    p[k] = calc_perimeter(perimeters[k], layer_count + k);

                do {
                    for (int k = 0; k < layers_N; ++k) {
                        for (int i = 0; i < p[k]; ++i) {
                            transform(map, perimeters[k][i][0], perimeters[k][i][1], goal);
                        }
                    }
                    finish_transform();

                    tail = 0;
                    for (int k = 0; k < layers_N; ++k) {
                        for (int i = 0; i < p[k]; ++i) {
                            tail += calcRange(SZ * perimeters[k][i][0], SZ * perimeters[k][i][1], map.length, goal);
                        }
                    }
                    tails.put(count++, tail);

                    if (count == steps) {
                        for (int k = 0; k < layers_N; ++k) {
                            for (int i = 0; i < p[k]; ++i) {
                                result += calcRange(SZ * perimeters[k][i][0], SZ * perimeters[k][i][1], map.length, goal);
                            }
                        }
                        return;
                    }

                    sum = 0;
                    for (int i = 0; i < p[0]; i++) {
                        sum += calcRange(SZ * perimeters[0][i][0], SZ * perimeters[0][i][1], map.length, goal);
                    }
                } while ((valOdd * p[0] - sum != 0) && (valEven * p[0] - sum != 0));

                L--;
                if (L == 1) {
                    PERIOD = count - BASEcount;
                } else if (L == 0) {
                    long FROM = count + (steps - count) % PERIOD - 2 * PERIOD;
                    long TO = count + (steps - count) % PERIOD - PERIOD;
                    long CNT = (steps - TO) / PERIOD;

                    if (oddOReven) {
                        if (steps % 2 == 1)
                            result = calcKernelEven(CNT + 4, valEven, valOdd);
                        else
                            result = calcKernelOdd(CNT + 4, valEven, valOdd);
                    } else {
                        if (steps % 2 == 1)
                            result = calcKernelOdd(CNT + 4, valOdd, valEven);
                        else
                            result = calcKernelEven(CNT + 4, valOdd, valEven);
                    }

                    tail = tails.get(FROM) + (CNT + 1) * (tails.get(TO) - tails.get(FROM));
                    result += tail;
                    return;
                }
            }
        }
    }

    private static int getX(char[][] map, int x) {
        int H = map.length, _H = H / 2;
        int idx_x = (_H - x) % H;
        idx_x = (idx_x < 0) ? (idx_x + H) : idx_x;

        return idx_x;
    }

    private static int getY(char[][] map, int y) {
        int W = map[0].length, _W = W / 2;
        int idx_y = (y + _W) % W;
        idx_y = (idx_y < 0) ? (idx_y + W) : idx_y;

        return idx_y;
    }

    private static char[][] init(List<String> lines) {
        char[][] map = new char[lines.size()][lines.get(0).length()];
        for (int i = 0; i < lines.size(); ++i) {
            System.arraycopy(lines.get(i).toCharArray(), 0, map[i], 0, lines.get(i).length());
        }

        return map;
    }

    private static int calc_perimeter(int[][] p, int count) {
        int len = 0, x = 0, y = count;

        if (count == 1) return 1;

        do {
            p[len][0] = x--;
            p[len++][1] = y--;
        } while (y != 0);
        do {
            p[len][0] = x++;
            p[len++][1] = y--;
        } while (x != 0);
        do {
            p[len][0] = x++;
            p[len++][1] = y++;
        } while (y != 0);
        do {
            p[len][0] = x--;
            p[len++][1] = y++;
        } while (x != 0);

        return 4 * count;
    }

    private static long calcRange(int x, int y, int N, int goal) {

        int _N = N / 2;
        long sum = 0;

        for (int i = _N; i >= -_N; --i) {
            for (int j = -_N; j <= _N; ++j) {
                if (points[goal + i + x].get(goal + j + y)) ++sum;
            }
        }

        return sum;
    }

    private static long calc(List<String> lines, int steps) {
        char[][] map = init(lines);
        flag = false;
        oddOReven = false;
        count = BASEcount = PERIOD = 0;
        result = 0;
        valEven = valOdd = 0;
        layer_count = 0;

        points[2*N].set(2*N);
        solve(map, 0, Math.max(2*N, map.length), steps - 1);

        return result;
    }

    private static long calcKernelEven(long layerN, long valEven, long valOdd) {
        long e = 1, o = 0;

        for (long i = 2; i <= layerN; ++i) {
            if (i % 2 == 1) {
                e += 4 * (i - 1);
            } else {
                o += 4 * (i - 1);
            }
        }

        return e * valEven + o * valOdd;
    }

    private static long calcKernelOdd(long layerN, long valEven, long valOdd) {
        long e = 0, o = 1;

        for (long i = 2; i <= layerN; ++i) {
            if (i % 2 == 1) {
                e += 4 * (i - 1);
            } else {
                o += 4 * (i - 1);
            }
        }

        return e * valEven + o * valOdd;
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

        System.out.println(calc(lines, 26501365));
    }
}