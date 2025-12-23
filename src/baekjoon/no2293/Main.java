package baekjoon.no2293;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];
        int[] dp = new int[k + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            coins[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 1;

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= k; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }

        System.out.println(dp[k]);

    }
}
