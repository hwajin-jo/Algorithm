package baekjoon.no2579;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[][] dp = new int[n][2];

        dp[0][0] = arr[0] + arr[1];
        dp[0][1] = arr[0] + arr[2];

        for (int i = 3; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]) + arr[i];
        }

    }
}
