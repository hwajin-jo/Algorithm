package baekjoon.no2624;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int k = sc.nextInt();

        int[] dp = new int[t + 1];
        dp[0] = 1;

        for (int i = 1; i <= k; i++) {
            int coinPrice = sc.nextInt();
            int coinCount = sc.nextInt();

            for (int j = t; j >= 0; j--) {
                for (int cnt = 1; cnt <= coinCount; cnt++) {
                    int nextValue = j + coinPrice * cnt;
                    if (nextValue > t) break;
                    dp[nextValue] += dp[j];
                }
            }
        }

        System.out.println(dp[t]);
    }
}
