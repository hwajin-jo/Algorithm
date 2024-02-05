package codingtest.autoever._2024_1.no1;

import java.util.Scanner;

public class Main {

    // 에스컬레이터
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n + 1][3];

        for (int i = 1; i <= n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            arr[i][2] = sc.nextInt();
        }

        int[][] dp = new int[n + 1][3];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = n + 2;
            }
        }

        if (arr[1][1] == 1) {
            if (arr[1][0] == 0) dp[1][0] = 1;
            if (arr[1][2] == 0) dp[1][2] = 1;
        } else {
            dp[1][0] = 0;
            dp[1][1] = 0;
            dp[1][2] = 0;
        }

        for (int i = 2; i <= n; i++) {
            if (arr[i][0] == 0 && arr[i - 1][0] == 0) {
                dp[i][0] = dp[i - 1][0];
            } else {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + 1;
            }

            if (arr[i][1] == 0 && arr[i - 1][1] == 0) {
                dp[i][1] = dp[i - 1][1];
            } else {
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + 1;
            }

            if (arr[i][2] == 0 && arr[i - 1][2] == 0) {
                dp[i][2] = dp[i - 1][2];
            } else {
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + 1;
            }
        }

        int ans = Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2]));
        System.out.println(ans);
    }
}
