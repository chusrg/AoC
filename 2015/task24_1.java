package year2015;

import java.util.*;

//       Task: https://adventofcode.com/2015/day/24
// Input Data: https://adventofcode.com/2015/day/24/input
//     Answer: 11266889531
public class task24_1 {
    private static void calc(List<Integer> weights, List<Integer> group, int sum, int target, int N, Set<List<Integer>> group0) {
        if (sum == target) {
            group.sort(Integer::compareTo);
            group0.add(group);
            return;
        }

        if (group.size() >= N || sum > target) {
            return;
        }

        for (int i = 0; i < weights.size(); ++i) {
            if (sum + weights.get(i) <= target) {
                List<Integer> copy = new ArrayList<>(weights);
                List<Integer> copyGroup = new ArrayList<>(group);
                copyGroup.add(weights.get(i));
                copy.remove(i);

                calc(copy, copyGroup, sum + weights.get(i), target, N, group0);
            }
        }
    }

    private static long calc(List<Integer> weights) {
        Set<List<Integer>> group1 = new HashSet<>();
        Set<List<Integer>> group2 = new HashSet<>();
        Set<List<Integer>> resultGroups = new HashSet<>();

        weights.sort(Integer::compareTo);
        int target = weights.stream().mapToInt(Integer::intValue).sum() / 3, sum = 0;
        int N = 0;
        for (int i = weights.size() - 1; i > 0; --i) {
            ++N;
            sum += weights.get(i);
            if (sum > target) break;
        }

        calc(weights, new ArrayList<>(), 0, target, N + 1, group1);

/*
        int p = 0, size = group1.size();
        for (List<Integer> g : group1) {
            List<Integer> subList = new ArrayList<>(weights);
            subList.removeAll(g);

            calc(subList, new ArrayList<>(), 0, target, subList.size()/2+1, group2);
            if (group2.size() > 0) {
                resultGroups.add(g);
                group2.clear();
            }
        }
*/
        resultGroups = group1;

        int[] minLen = new int[1];
        minLen[0] = Integer.MAX_VALUE;
        resultGroups.forEach( g -> minLen[0] = Math.min(g.size(), minLen[0]));

        Long[] result = new Long[1];
        result[0] = Long.MAX_VALUE;

        resultGroups.stream().filter(group -> group.size() == minLen[0]).forEach(g -> g.stream()
                .map(Long::new)
                .mapToLong(Long::longValue)
                .reduce((a, b) -> a * b)
                .ifPresent(val -> result[0] = Math.min(val, result[0]))
        );

        return result[0];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> weights = new ArrayList<>();
        String str = in.nextLine();

        while (!"EOF".equals(str)) {
            weights.add(Integer.parseInt(str));
            str = in.nextLine();
        }

        System.out.println(calc(weights));
    }
}