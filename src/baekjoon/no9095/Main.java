package baekjoon.no9095;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();
            int[] dp = new int[11];
            dp[1] = 1;
            dp[2] = 1;
            dp[3] = 1;

            System.out.println(solve(N, dp));
        }
    }
    static int solve(int N, int[] dp) {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= 3; j++) {
                if (i - j >= 0) {
                    dp[i] += dp[i - j];
                }
            }
        }

        return dp[N];
    }
}
