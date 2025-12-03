package year2015;

import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

//       Task: https://adventofcode.com/2015/day/4
// Input Data: https://adventofcode.com/2015/day/4/input
//     Answer: 282749
public class task4_1 {
    public static String MD5(String md5) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return null;
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, InterruptedException {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine().trim();

        for (int i = 0; i < Integer.MAX_VALUE; ++i) {
            String val = MD5(String.format("%s%d", line, i));
            Thread.sleep(5);
            if ("00000".equals(val.substring(0, 5))) {
                System.out.println(i);
                return;
            }
        }
    }
}