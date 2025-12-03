package year2015;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//       Task: https://adventofcode.com/2015/day/16
// Input Data: https://adventofcode.com/2015/day/16/input
//     Answer: 323
public class task16_2 {

    private static final HashMap<String, Integer> map = new HashMap<String, Integer>() {{
        put("children", 3);
        put("cats", 7);
        put("samoyeds", 2);
        put("pomeranians", 3);
        put("akitas", 0);
        put("vizslas", 0);
        put("goldfish", 5);
        put("trees", 3);
        put("cars", 2);
        put("perfumes", 1);
    }};

    private static boolean check(String key, Integer value) {
        switch (key) {
            case "cats":
            case "trees":
                return map.get(key) < value;
            case "pomeranians":
            case "goldfish":
                return map.get(key) > value;
        }

        return map.get(key).equals(value);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        while (!"EOF".equals(str)) {
            Pattern pattern = Pattern.compile("(\\w+) (\\d+): (\\w+): (\\d+), (\\w+): (\\d+), (\\w+): (\\d+)");
            Matcher m = pattern.matcher(str);
            if (m.find()) {

                if (check(m.group(3), Integer.parseInt(m.group(4))) &&
                        check(m.group(5), Integer.parseInt(m.group(6))) &&
                        check(m.group(7), Integer.parseInt(m.group(8)))) {
                    System.out.printf("\n%s", m.group(2));
                    break;
                }
            }
            str = in.nextLine().trim();
        }
    }
}