package baekjoon.no10844;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] dp = new int[N + 1][10];
        final int MOD = 1000000000;

        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                switch (j) {
                    case 0:
                        dp[i][j] = dp[i - 1][j + 1] % MOD;
                        break;
                    case 9:
                        dp[i][j] = dp[i - 1][j - 1] % MOD;
                        break;
                    default:
                        dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD;
                        break;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i <= 9; i++) {
            sum = (sum + dp[N][i]) % MOD;
        }

        System.out.println(sum);
    }
}
