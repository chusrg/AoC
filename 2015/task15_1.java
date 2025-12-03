package year2015;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//       Task: https://adventofcode.com/2015/day/15
// Input Data: https://adventofcode.com/2015/day/15/input
//     Answer: 18965440
public class task15_1 {

    private static long maxScore = 0;
    private static final int propCounts = 5;

    private static void calc(int[][] arr, List<Integer> res, int count, int targetSum) {
        Optional<Integer> s = res.stream().reduce(Integer::sum);

        int[] sum = new int[1];
        s.ifPresent(e -> sum[0] = s.get());

        if (sum[0] > targetSum) return;

        if (res.size() == count - 1) {
            res.add(targetSum - sum[0]);

            for (int j = 0; j < propCounts; ++j) arr[count][j] = 0;

            for (int i = 0; i < count; ++i) {
                for (int j = 0; j < propCounts; ++j) {
                    arr[count][j] += res.get(i) * arr[i][j];
                }
            }

            long score = 1;
            for (int j = 0; j < propCounts - 1; ++j) {
                if (arr[count][j] < 0) {
                    score = 0;
                    break;
                }
                score *= arr[count][j];
            }
            arr[count][propCounts - 1] = 0;

            if (score > maxScore) {
                maxScore = score;
            }
            return;
        }

        for (int i = 1; i < targetSum - sum[0]; ++i) {
            List<Integer> r = new ArrayList<>(res);
            r.add(i);
            calc(arr, r, count, targetSum);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int[][] weight = new int[10][propCounts];
        int count = 0;

        while (!"EOF".equals(str)) {
            Pattern pattern = Pattern.compile("([\\w:]+).+?([\\-\\d]+).+?([\\-\\d]+).+?([\\-\\d]+).+?([\\-\\d]+).+?([\\-\\d]+)");
            Matcher m = pattern.matcher(str);
            if (m.find()) {
                for (int i = 0; i < propCounts; ++i)
                    weight[count][i] = Integer.parseInt(m.group(i + 2));
            }
            ++count;
            str = in.nextLine().trim();
        }

        calc(weight, new ArrayList<>(), count, 100);
        System.out.println(maxScore);
    }
}