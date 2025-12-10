package baekjoon.no14503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] room;
    static int ans;
    // 북 동 남 서
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc= {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        room = new int[N][M];
        ans = 0;
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cleanRoom(r, c, d);
        System.out.println(ans);
    }

    static private void cleanRoom(int nowR, int nowC, int nowD) {
        while (true) {
            if (room[nowR][nowC] == 0) {
                ans++;
                room[nowR][nowC] = 2;
            }

            if (isDirty(nowR, nowC)) {
                int nd = nowD - 1;

                if (nd < 0) nd = 3;

                int nr = nowR + dr[nd];
                int nc = nowC + dc[nd];

                if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;

                if (room[nr][nc] == 0) {
                    nowR = nr;
                    nowC = nc;
                }
                nowD = nd;
            } else {
                int nr = nowR + dr[nowD] * -1;
                int nc = nowC + dc[nowD] * -1;

                if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;

                if (room[nr][nc] == 1)
                    break;

                nowR = nr;
                nowC = nc;
            }
        }
    }

    static private boolean isDirty(int r, int c) {
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
            if (room[nr][nc] == 0) {
                return true;
            }
        }
        return false;
    }
}
