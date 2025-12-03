package year2015;

import java.util.*;
import java.util.stream.Collectors;

//       Task: https://adventofcode.com/2015/day/17
// Input Data: https://adventofcode.com/2015/day/17/input
//     Answer: 17
public class task17_2 {

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
        List<List<Integer>> sortedSolevesByLength = solves
                .stream()
                .sorted(Comparator.comparingInt(List::size))
                .collect(Collectors.toList());

        System.out.println(sortedSolevesByLength
                .stream()
                .filter(e -> e.size() == sortedSolevesByLength.get(0).size()).count());
    }
}
