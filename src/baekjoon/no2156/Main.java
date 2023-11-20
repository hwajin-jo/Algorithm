package baekjoon.no2156;

import java.util.Scanner;

public class Main {

    static int[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        dp = new int[3][n + 1];

        int[] wine = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            wine[i] = sc.nextInt();
        }

        System.out.println(solve(wine, n));
    }

    static int solve(int[] wine, int n) {
        dp[0][1] = 0; // n번째 선택안함
        dp[1][1] = wine[1]; // n-1번째 선택 안함, n번째 선택
        dp[2][1] = wine[1]; // n-1, n번째 선택

        for (int i = 2; i <= n; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], Math.max(dp[1][i - 1], dp[2][i - 1]));

            dp[1][i] = dp[0][i - 1] + wine[i];
            dp[2][i] = dp[1][i - 1] + wine[i];
        }

        return Math.max(dp[0][n], Math.max(dp[1][n], dp[2][n]));
    }
}
