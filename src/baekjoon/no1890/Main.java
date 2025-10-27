package baekjoon.no1890;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][N];
        long[][] dp = new long[N][N]; // 해당 칸에 도달하는 경우의 수

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = 1;

        int[] dr = {0, 1};
        int[] dc = {1, 0};

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (r == N - 1 && c == N - 1) continue;
                int step = arr[r][c];

                for (int k = 0; k < 2; k++) {
                    int nr = r + dr[k] * step;
                    int nc = c + dc[k] * step;

                    if (nr >= N || nc >= N) continue;
                    dp[nr][nc] += dp[r][c];
                }
            }
        }

        System.out.println(dp[N - 1][N - 1]);
    }
}
