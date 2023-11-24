package baekjoon.no1932;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] arr = new int[n + 1][n + 1];
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        dp[1][0] = arr[1][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i + 1][j] = Math.max(dp[i][j] + arr[i + 1][j], dp[i + 1][j]);
                dp[i + 1][j + 1] = Math.max(dp[i][j] + arr[i + 1][j + 1], dp[i + 1][j + 1]);
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[n][i]);
        }

        System.out.println(ans);
    }
}
