package baekjoon.no14916;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 100001);

        if (n == 1) {
            System.out.println(-1);
            return;
        } else if (n == 2 || n == 5) {
            System.out.println(1);
            return;
        }

        if (n >= 4) {
            dp[2] = 1;
            dp[4] = 2;
        }

        if (n > 5) {
            dp[5] = 1;
        }


        for (int i = 6; i <= n; i++) {
            dp[i] = Math.min(Math.min(dp[i - 2], dp[i - 5]) + 1, dp[i]);
        }

        if (dp[n] == 100001)
            System.out.println(-1);
        else
            System.out.println(dp[n]);
    }
}
