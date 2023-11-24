package baekjoon.no2293;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] coins = new int[n];
        int[] dp = new int[k + 1];

        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        dp[0] = 1;
        // 이렇게 하면 똑같은 조합이더라도 순서가 다르게 세면 추가적으로 중복 해서 계산
        // dp[3]을 만드는데, +dp[2] 을 더하는 경우와 +dp[1]을 하는 경우 (1, 2), (2, 1) 이 두 번 세짐
//        for (int i = 0; i <= k; i++) {
//            for (int j = 0; j < n; j++) {
//                if (i + coins[j] <= k)
//                    dp[i + coins[j]] += dp[i];
//            }
//        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j + coins[i] <= k; j++) {
                dp[j + coins[i]] += dp[j];
            }
        }
        System.out.println(dp[k]);
    }
}
