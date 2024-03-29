package baekjoon.no1463;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 100001);
        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i / 2] + 1, dp[i]);
            }

            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i / 3] + 1, dp[i]);
            }

            dp[i] = Math.min(dp[i - 1] + 1, dp[i]);
        }

        System.out.println(dp[n]);
    }
}
