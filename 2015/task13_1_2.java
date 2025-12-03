package year2015;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//         Task: https://adventofcode.com/2015/day/13
//   Input Data: https://adventofcode.com/2015/day/13/input
// Answer task1: 618   (default)
// Answer task2: 601   (uncomment line 65)
public class task13_1_2 {

    private static int max = 0;

    private static void calc(int[][] map, int size, List<Integer> comb) {
        if (comb.size() == size) {
            int sum = 0;
            for (int i = 0; i < comb.size() - 1; ++i) {
                sum += map[comb.get(i + 1)][comb.get(i)] + map[comb.get(i)][comb.get(i + 1)];
            }
            sum += map[comb.get(comb.size() - 1)][comb.get(0)] + map[comb.get(0)][comb.get(comb.size() - 1)];

            if (sum > max) {
                max = sum;
            }

            return;
        }

        for (int i = 0; i < size; ++i) {
            ArrayList<Integer> c = new ArrayList<>(comb);
            if (!c.contains(i)) {
                c.add(i);
                calc(map, size, c);
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int sum = 0;

        List<String> persons = new ArrayList<>(), lines = new ArrayList<>();

        while (!"EOF".equals(str)) {
            lines.add(str);
            str = in.nextLine().trim();
        }

        int[][] graph = new int[lines.size()][lines.size()];
        Pattern pattern = Pattern.compile("(\\w+).*(gain|lose) (\\d+) happiness units by sitting next to (\\w+)\\.");
        for (String s : lines) {
            Matcher matcher = pattern.matcher(s);
            if (matcher.find()) {
                String from = matcher.group(1), to = matcher.group(4);
                if (!persons.contains(from)) persons.add(from);
                if (!persons.contains(to)) persons.add(to);

                graph[persons.indexOf(from)][persons.indexOf(to)] = ("lose".equals(matcher.group(2)) ? -1 : 1) * Integer.parseInt(matcher.group(3));
            }
        }
        int size = persons.size()/*+1*/;

        final List<Integer> pList = new ArrayList<>();
        for (int i = 0; i < size; ++i) {
            pList.add(i);
        }

        for (int i = 0; i < size; ++i) {
            final List<Integer> c = new ArrayList<>();
            c.add(i);
            calc(graph, size, c);
        }

        System.out.println(max);
    }
}
