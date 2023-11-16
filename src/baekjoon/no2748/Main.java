package baekjoon.no2748;

import java.util.Scanner;

public class Main {
    static long[] memo;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        memo = new long[N + 1];

        System.out.println(fibo(N));
    }

    static long fibo(int i) {
        if (i == 0)
            return 0;

        if (i == 1)
            return 1;

        if (memo[i] != 0)
            return memo[i];
        else {
            memo[i] = fibo(i - 1) + fibo(i - 2);
            return memo[i];
        }
    }
}
