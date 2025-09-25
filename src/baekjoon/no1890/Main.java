package baekjoon.no1890;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] arr = new int[N][N];
        long[][] dp = new long[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int[] dr = {1, 0};
        int[] dc = {0, 1};
        dp[0][0] = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == N - 1 && j == N - 1) break;

                if (dp[i][j] == 0) continue;

                int step = arr[i][j];

                for (int d = 0; d < 2; d++) {
                    int nr = i + dr[d] * step;
                    int nc = j + dc[d] * step;

                    if (nr >= N || nc >= N) continue;

                    dp[nr][nc] += dp[i][j];
                }
            }
        }

        System.out.println(dp[N - 1][N - 1]);
    }
}
