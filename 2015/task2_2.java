package year2015;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

//       Task: https://adventofcode.com/2015/day/2
// Input Data: https://adventofcode.com/2015/day/2/input
//     Answer: 3842356
public class task2_2 {
    private static int calc(String[] sides) {
        List<Integer> abc = Arrays.stream(sides).map(Integer::parseInt).sorted().collect(Collectors.toList());

        return 2*(abc.get(0)+abc.get(1))+abc.get(0)*abc.get(1)*abc.get(2);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int sum = 0;

        do {
            sum += calc(str.split("x"));
            str = in.nextLine().trim();
        } while (!"EOF".equals(str));

        System.out.println(sum);
    }
}
