package year2015;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//       Task: https://adventofcode.com/2015/day/14
// Input Data: https://adventofcode.com/2015/day/14/input
//     Answer: 2655
public class task14_1 {

    private static int calc(List<String> lines, final int T) {
        int maxDist = Integer.MIN_VALUE;

        Pattern pattern = Pattern.compile("(\\w+).+?(\\d+).+?(\\d+).+?(\\d+).+");
        for (String s : lines) {
            Matcher matcher = pattern.matcher(s);
            if (matcher.find()) {
                int t = 0, dist;
                int[] time = new int[T];

                while (t < T) {
                    int speed = Integer.parseInt(matcher.group(2));
                    int runTime = Integer.parseInt(matcher.group(3));
                    int restTime = Integer.parseInt(matcher.group(4));

                    for (int i = 0; i < runTime && t + i < T; ++i) {
                        time[t + i] = speed;
                    }
                    t += Integer.parseInt(matcher.group(3));

                    for (int i = 0; i < restTime && t + i < T; ++i) {
                        time[t + i] = 0;
                    }
                    t += restTime;
                }

                dist = Arrays.stream(time).sum();
                if (dist > maxDist) {
                    maxDist = dist;
                }
            }
        }

        return maxDist;
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