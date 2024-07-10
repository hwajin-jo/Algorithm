package baekjoon.no15988;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        long[] dp = new long[1000001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i < dp.length; i++) {
            dp[i] = ( dp[i - 1] + dp[i - 2] + dp[i - 3] ) % 1000000009;
        }

        while (T-- > 0) {
            int n = sc.nextInt();

            System.out.println(dp[n]);
        }
    }
}
