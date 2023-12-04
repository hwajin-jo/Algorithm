package baekjoon.no15486;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] consultant = new int[n + 2][2];

        for (int i = 1; i <= n; i++) {
            consultant[i][0] = sc.nextInt();
            consultant[i][1] = sc.nextInt();
        }

        int[] dp = new int[n + 2];
        for (int i = 1; i <= n + 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i]);
            if (i + consultant[i][0] > n + 1) continue;
            dp[i + consultant[i][0]] = Math.max(dp[i + consultant[i][0]], dp[i] + consultant[i][1]);
        }

        System.out.println(dp[n + 1]);
    }
}
