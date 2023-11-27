package baekjoon.no2294;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] dp = new int[100001];
        Arrays.fill(dp, 100001);

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
            dp[coins[i]] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                if (j - coins[i] >= 0) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }

        if (dp[k] == 100001)
            System.out.println(-1);
        else
            System.out.println(dp[k]);
    }
}
