package baekjoon.no2417;

import java.util.Scanner;

public class Main {

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        long N = sc.nextLong();

        long l = 0, r = N;

        long result = 0;
        while (l <= r) {
            long m = (l + r) / 2;

            if (Math.pow(m, 2) >= N) {
                result = m;
                r = m - 1;
            }
            else {
                l = m + 1;
            }
        }

        System.out.println(result);
    }
}
