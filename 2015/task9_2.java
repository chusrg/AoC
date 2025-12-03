package year2015;

import java.util.*;

//       Task: https://adventofcode.com/2015/day/9
// Input Data: https://adventofcode.com/2015/day/9/input
//     Answer: 804
public class task9_2 {

    private static final Map<Integer, String> citiesNamesMap = new HashMap<>();
    private static List<Integer> maxPath = new ArrayList<>();
    private static int max = Integer.MIN_VALUE;

    private static void calc(int[][] map, int size, List<Integer> path, int city, int len, int count) {
        if (count == size) {
            if (len > max) {
                max = len;
                maxPath = path;
            }
        }

        for (int i = 1; i <= size; ++i) {
            if (map[city][i] != 0 && i != city && !path.contains(i)) {
                ArrayList<Integer> newPath = new ArrayList<>(path);
                newPath.add(i);
                calc(map, size, newPath, i, len + map[city][i], count+1 );
            }
        }
    }

    public static void main(String[] args) {
        final Map<String, Integer> citiesMap = new HashMap<>();
        int[][] map = new int[100][100];
        int i = 1, SIZE = 0;

        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        while (!"EOF".equals(str)) {
            String[] data = str.split("="), towns;
            String city1, city2;

            towns = data[0].trim().split(" to ");
            city1 = towns[0].trim();
            city2 = towns[1].trim();

            if (!citiesMap.containsKey(city1)) {
                citiesNamesMap.put(i, city1);
                citiesMap.put(city1, i);
                i++;
                ++SIZE;
            }

            if (!citiesMap.containsKey(city2)) {
                citiesNamesMap.put(i, city2);
                citiesMap.put(city2, i);
                i++;
                ++SIZE;
            }

            map[citiesMap.get(city1)][citiesMap.get(city2)] =
                    map[citiesMap.get(city2)][citiesMap.get(city1)] = Integer.parseInt(data[1].trim());
            str = in.nextLine().trim();
        }

        for (i = 1; i <= SIZE; ++i){
            List<Integer> path = new ArrayList<>();
            path.add(i);
            calc(map, SIZE, path, i, 0, 1);
        }

        for (i = 0; i < maxPath.size(); ++i) {
            System.out.printf("%s -> ", citiesNamesMap.get(maxPath.get(i)));
        }
        System.out.println(max);
    }
}