package year2015;

import java.util.*;

//       Task: https://adventofcode.com/2015/day/3
// Input Data: https://adventofcode.com/2015/day/3/input
//     Answer: 2565
public class task3_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine().trim(), key;
        final Map<String, Integer> map = new HashMap<>();

        int x = line.length(), y = line.length();
        key = String.format("%08d%08d", x, y);
        map.put(key, 1);

        for (int i = 0; i < line.length(); ++i) {
            switch (line.charAt(i)) {
                case '^': ++y; break;
                case 'v': --y; break;
                case '<': --x; break;
                case '>': ++x; break;
            }

            key = String.format("%08d%08d", x, y);
            if (!map.containsKey(key)) {
                map.put(key, 1);
            } else {
                map.put(key, map.get(key) + 1);
            }
        }

        System.out.println(map.values().size());
    }
}
