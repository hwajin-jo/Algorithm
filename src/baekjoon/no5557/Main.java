package baekjoon.no5557;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        long[][] dp = new long[n][21];
        dp[0][arr[0]] = 1;
        int plus;
        int minus;
        for (int i = 1; i < n - 1; i++) {
            for (int j = 0; j < 21; j++) {
                if (dp[i - 1][j] != 0) {
                    plus = j + arr[i];
                    minus = j - arr[i];

                    if (0 <= plus && plus <= 20) {
                        dp[i][plus] += dp[i - 1][j];
                    }
                    if (0 <= minus && minus <= 20) {
                        dp[i][minus] += dp[i - 1][j];
                    }
                }
            }
        }

        System.out.println(dp[n - 2][arr[n - 1]]);
    }
}
