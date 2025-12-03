package year2015;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//       Task: https://adventofcode.com/2015/day/14
// Input Data: https://adventofcode.com/2015/day/14/input
//     Answer: 1059
public class task14_2 {

    private static int calc(List<String> lines, final int T) {
        int[][] time = new int[lines.size()][T + 2];

        Pattern pattern = Pattern.compile("(\\w+).+?(\\d+).+?(\\d+).+?(\\d+).+");
        for (int j = 0; j < lines.size(); ++j) {
            Matcher matcher = pattern.matcher(lines.get(j));
            if (matcher.find()) {
                int t = 1;
                while (t <= T) {
                    int speed = Integer.parseInt(matcher.group(2));
                    int runTime = Integer.parseInt(matcher.group(3));
                    int restTime = Integer.parseInt(matcher.group(4));

                    for (int i = 0; i < runTime && t + i <= T; ++i) {
                        time[j][t + i] = speed;
                    }
                    t += Integer.parseInt(matcher.group(3));

                    for (int i = 0; i < restTime && t + i <= T; ++i) {
                        time[j][t + i] = 0;
                    }
                    t += restTime;
                }
            }
        }

        for (int i = 1; i <= T; ++i) {
            for (int j = 0; j < lines.size(); ++j) {
                time[j][T + 1] += time[j][i];
            }

            int maxDist = 0;
            for (int k = 0; k < lines.size(); ++k) {
                if (time[k][T + 1] > maxDist) maxDist = time[k][T + 1];
            }

            for (int k = 0; k < lines.size(); ++k) {
                if (time[k][T + 1] == maxDist) time[k][0] += 1;
            }
        }

        int maxScore = 0;
        for (int k = 0; k < lines.size(); ++k) {
            if (time[k][0] > maxScore) maxScore = time[k][0];
        }

        return maxScore;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        List<String> lines = new ArrayList<>();

        while (!"EOF".equals(str)) {
            lines.add(str);
            str = in.nextLine().trim();
        }

        System.out.println(calc(lines, 2503));
    }
}