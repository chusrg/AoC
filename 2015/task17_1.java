package year2015;

import java.util.*;

//       Task: https://adventofcode.com/2015/day/17
// Input Data: https://adventofcode.com/2015/day/17/input
//     Answer: 1638
public class task17_1 {

    private static final Set<List<Integer>> solves = new HashSet<>();

    private static void calc(List<Integer> c, List<Integer> solve, int V, int sum, int p) {
        if (sum == V && !solves.contains(solve)) {
            solves.add(solve);
            return;
        } else if (sum > V) return;

        for (int i = p; i < c.size(); ++i) {
            if (solve.contains(i)) continue;
            final List<Integer> s = new ArrayList<>(solve);

            s.add(i);
            s.sort(Integer::compare);
            calc(c, s, V, sum + c.get(i), p + 1);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        List<Integer> containers = new ArrayList<>();

        while (!"EOF".equals(str)) {
            containers.add(Integer.parseInt(str));
            str = in.nextLine().trim();
        }

        calc(containers, new ArrayList<>(), 150, 0, 0);
        System.out.println(solves.size());
    }
}
