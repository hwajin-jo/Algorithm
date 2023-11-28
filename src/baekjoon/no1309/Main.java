package baekjoon.no1309;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        final int LEFT = 0;
        final int RIGHT = 1;
        final int NONE = 2;

        int[][] dp = new int[n + 1][3];

        dp[1][LEFT] = 1;
        dp[1][RIGHT] = 1;
        dp[1][NONE] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i][LEFT] = (dp[i - 1][RIGHT] + dp[i - 1][NONE]) % 9901;
            dp[i][RIGHT] = (dp[i - 1][LEFT] + dp[i - 1][NONE]) % 9901;
            dp[i][NONE] = (dp[i - 1][LEFT] + dp[i - 1][RIGHT] + dp[i - 1][NONE]) % 9901;
        }

        int sum = 0;

        sum = (dp[n][LEFT] + dp[n][RIGHT] + dp[n][NONE]) % 9901;

        System.out.println(sum);
    }
}
