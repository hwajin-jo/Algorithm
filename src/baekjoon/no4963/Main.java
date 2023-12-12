package baekjoon.no4963;

import java.util.Scanner;

public class Main {

    static int[] dr = {0, 0, -1, 1, 1, -1, 1, -1};
    static int[] dc = {-1, 1, 0, 0, 1, 1, -1, -1};
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int w = sc.nextInt();
            int h = sc.nextInt();
            if (w == 0 && h == 0) break;

            map = new int[h][w];
            visited = new boolean[h][w];


            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            int cnt = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!visited[i][j] && map[i][j] == 1) {
                        dfs(i, j, h, w);
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);
        }
    }

    static void dfs(int r, int c, int h, int w) {
        visited[r][c] = true;
        for (int i = 0; i < 8; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr < 0 || nc < 0 || nr >= h || nc >= w) continue;
            if (visited[nr][nc]) continue;
            if (map[nr][nc] == 0) continue;
            dfs(nr, nc, h, w);
        }
    }
}
