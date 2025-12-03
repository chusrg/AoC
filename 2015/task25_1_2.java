package year2015;

//       Task: https://adventofcode.com/2015/day/25
// Input Data: https://adventofcode.com/2015/day/25/input
//     Answer: 9132360
public class task25_1_2 {
    private static long calc(long column, long row) {
        long base = 20151125;
        long a = 252533;
        long b = 33554393;

        long N = getN(column, row);
        for (long i = 1; i < N; ++i) {
            base = base * a % b;
        }

        return base;
    }

    private static long getN(long column, long row) {
        long N = 0;
        while (column != 0) {
            column--;
            row++;
            N++;
        }

        for (long i = 1; i < row - 1; ++i) {
            N += i;
        }

        return N;
    }

    public static void main(String[] args) {
        System.out.println(calc(3075, 2981));
    }
}