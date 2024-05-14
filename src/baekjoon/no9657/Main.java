package baekjoon.no9657;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 1;
        dp[4] = 1;
        for (int i = 5; i <= n; i++) {
            if (dp[i - 4] % 2 == 0 ||
                dp[i - 3] % 2 == 0 ||
                dp[i - 1] % 2 == 0) {
                dp[i] = 1;
            } else {
                dp[i] = 2;
            }
        }

        if (dp[n] == 1) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }
    }
}
