package year2015;

import java.util.*;

//       Task: https://adventofcode.com/2015/day/19
// Input Data: https://adventofcode.com/2015/day/19/input
//     Answer: 207
public class task19_2 {
    private static final List<String> rules = new ArrayList<>();
    private static long min = Integer.MAX_VALUE;

    private static boolean check(StringBuilder base) {
        for (int j = 0; j < rules.size(); ++j) {
            String[] t = rules.get(j).split(" => ");
            if (base.indexOf(t[1]) != -1) {
                if ("e".equals(t[0]) && !base.toString().equals(t[1])) {
                    continue;
                }

                return true;
            }
        }
        return false;
    }

    private static void calc(List<Integer> path, StringBuilder base) {
        if (base.toString().equals("e")) {
            if (path.size() < min) min = path.size();
            return;
        }

        for (int j = 0; j < rules.size(); ++j) {
            String[] t = rules.get(j).split(" => ");

            if ("e".equals(t[0])) {
                if (t[1].equals(base.toString())) {
                    List<Integer> p = new ArrayList<>(path);
                    p.add(j);
                    calc(p, new StringBuilder("e"));
                    return;
                }
            } else {
                int idx = 0;
                StringBuilder copy = new StringBuilder(base);
                while ((idx = copy.indexOf(t[1], idx)) != -1) {
                    copy = new StringBuilder(base);
                    copy.replace(idx, idx + t[1].length(), t[0]);
                    idx += t[1].length();
                    //System.out.printf("%s->%s (%s)\n",base.toString(), copy.toString(),rules.get(j));
                    if (check(copy) && copy.length() < base.length()) {
                        List<Integer> p = new ArrayList<>(path);
                        p.add(j);
                        calc(p, copy);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine(), baseMolecule;

        while (!"".equals(str)) {
            rules.add(str);
            str = in.nextLine();
        }
        baseMolecule = in.nextLine();

        calc(new ArrayList<>(), new StringBuilder(baseMolecule));
        System.out.println(min);
    }
}
