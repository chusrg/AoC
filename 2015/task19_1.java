package year2015;

import java.util.*;

//       Task: https://adventofcode.com/2015/day/19
// Input Data: https://adventofcode.com/2015/day/19/input
//     Answer: 576
public class task19_1 {
    private static Set<String> allMolecules = new HashSet<>();

    private static long calc(List<String> rules, String base) {

        for (int j = 0; j < rules.size(); ++j) {
            String r = rules.get(j);
            String[] t = r.split(" => ");

            int idx = 0;
            StringBuilder copy = new StringBuilder(base);
            while (idx < base.length() && (idx = copy.indexOf(t[0], idx)) != -1) {
                copy.replace(idx, idx + t[0].length(), t[1]);
                idx += t[0].length();
                allMolecules.add(copy.toString());
                copy = new StringBuilder(base);
            }
        }

        return allMolecules.size();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> rules = new ArrayList<>();
        String str = in.nextLine(), baseMolecule;

        while (!"".equals(str)) {
            rules.add(str);
            str = in.nextLine();
        }
        baseMolecule = in.nextLine();

        System.out.println(calc(rules, baseMolecule));
    }
}
