package baekjoon.no11048;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[n][m];
        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int[] dr = {1, 0, 1};
        int[] dc = {0, 1, 1};

        dp[0][0] = arr[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int d = 0; d < 3; d++) {
                    int nr = i + dr[d];
                    int nc = j + dc[d];

                    if (nr >= n || nc >= m) continue;
                    if (dp[nr][nc] < dp[i][j] + arr[nr][nc]) {
                        dp[nr][nc] = dp[i][j] + arr[nr][nc];
                    }
                }
            }
        }

        System.out.println(dp[n - 1][m - 1]);
    }
}
