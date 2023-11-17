package baekjoon.no11727;

import java.util.Scanner;

public class Main {

    static int[] dp = new int[1001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        System.out.println(solve(N));
    }

    static int solve(int N) {
        dp[1] = 1;
        dp[2] = 3;

        for (int i = 3; i <= N; i++) {
            dp[i] += (dp[i - 1] + dp[i - 2]) % 10007;
        }

        return dp[N];
    }
}
