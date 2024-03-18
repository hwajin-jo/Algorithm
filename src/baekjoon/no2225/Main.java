package baekjoon.no2225;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[][] dp = new int[k + 1][n + 1];

        dp[0][0] = 1;

        final int mod = 1000000000;

        for (int i = 1; i <= k; i++) {
            for (int j = 0; j <= n; j++) {
                for (int m = 0; m <= j; m++) {
                    dp[i][j] += dp[i - 1][j - m];
                    dp[i][j] %= mod;
                }

            }
        }

        System.out.println(dp[k][n]);

    }
}
