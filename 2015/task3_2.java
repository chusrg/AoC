package year2015;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//       Task: https://adventofcode.com/2015/day/3
// Input Data: https://adventofcode.com/2015/day/3/input
//     Answer: 2639
public class task3_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine().trim(), key;
        final Map<String, Integer> map = new HashMap<>();

        int x1 = line.length(), y1 = line.length(),
            x2 = line.length(), y2 = line.length();

        key = String.format("%08d%08d", x1, y1);
        map.put(key, 2);

        for (int i = 0; i < line.length(); ++i) {

            if ( i % 2 == 0 ) {
                switch (line.charAt(i)) {
                    case 'v': --y1; break;
                    case '^': ++y1; break;
                    case '<': --x1; break;
                    case '>': ++x1; break;
                }

                key = String.format("%08d%08d", x1, y1);
            } else {
                switch (line.charAt(i)) {
                    case 'v': --y2; break;
                    case '^': ++y2; break;
                    case '<': --x2; break;
                    case '>': ++x2; break;
                }

                key = String.format("%08d%08d", x2, y2);
            }

            if (!map.containsKey(key)) {
                map.put(key, 1);
            } else {
                map.put(key, map.get(key) + 1);
            }
        }

        System.out.println(map.values().size());
    }
}