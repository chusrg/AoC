package year2015;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//       Task: https://adventofcode.com/2015/day/16
// Input Data: https://adventofcode.com/2015/day/16/input
//     Answer: 213
public class task16_1 {

    private static final HashMap<String,Integer> map = new HashMap<String,Integer>(){{
        put("children",3);
        put("cats",7);
        put("samoyeds",2);
        put("pomeranians",3);
        put("akitas",0);
        put("vizslas",0);
        put("goldfish",5);
        put("trees",3);
        put("cars",2);
        put("perfumes",1);
    }};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        while (!"EOF".equals(str)) {
            Pattern pattern = Pattern.compile("(\\w+) (\\d+): (\\w+): (\\d+), (\\w+): (\\d+), (\\w+): (\\d+)");
            Matcher m = pattern.matcher(str);
            if (m.find()) {

                if (    map.get(m.group(3)).equals(Integer.parseInt(m.group(4))) &&
                        map.get(m.group(5)).equals(Integer.parseInt(m.group(6))) &&
                        map.get(m.group(7)).equals(Integer.parseInt(m.group(8)))  )
                {
                    System.out.printf("\n%s",m.group(2));
                    break;
                }
            }
            str = in.nextLine().trim();
        }
    }
}