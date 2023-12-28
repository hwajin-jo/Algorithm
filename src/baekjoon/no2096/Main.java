package baekjoon.no2096;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        int N = sc.nextInt();
        int[][] arr = new int[N][3];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int[][] dp = new int[N][3];
        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];

        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.max(dp[i - 1][0] + arr[i][0], dp[i - 1][1] + arr[i][0]);
            dp[i][1] = Math.max(dp[i - 1][2] + arr[i][1], Math.max(dp[i - 1][0] + arr[i][1], dp[i - 1][1] + arr[i][1]));
            dp[i][2] = Math.max(dp[i - 1][1] + arr[i][2], dp[i - 1][2] + arr[i][2]);
        }

        int max = 0;

        for (int i = 0; i < 3; i++) {
            max = Math.max(max, dp[N - 1][i]);
        }

        dp = new int[N][3];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = 1000001;
            }
        }

        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];
        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.min(dp[i - 1][0] + arr[i][0], dp[i - 1][1] + arr[i][0]);
            dp[i][1] = Math.min(dp[i - 1][2] + arr[i][1], Math.min(dp[i - 1][0] + arr[i][1], dp[i - 1][1] + arr[i][1]));
            dp[i][2] = Math.min(dp[i - 1][1] + arr[i][2], dp[i - 1][2] + arr[i][2]);
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            min = Math.min(min, dp[N - 1][i]);
        }

        System.out.println(max + " " + min);
    }
}
