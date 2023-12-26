package baekjoon.no7569;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int h = sc.nextInt();
        int[][][] board = new int[h][n][m];
        boolean[][][] visited = new boolean[h][n][m];

        Queue<Point> q = new LinkedList<>();
        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    board[k][i][j] = sc.nextInt();
                    if (board[k][i][j] == 1) {
                        q.add(new Point(i, j, k));
                        visited[k][i][j] = true;
                    }
                }
            }
        }

        boolean flag = true;
        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[k][i][j] == 0) {
                        flag = false;
                    }
                }
            }
        }

        if (flag) {
            System.out.println(0);
            return;
        }

        int[] dr = {0, 0, -1, 1, 0, 0};
        int[] dc = {0, 0, 0, 0, -1, 1};
        int[] dh = {-1, 1, 0, 0, 0, 0};
        while (!q.isEmpty()) {
            Point now = q.poll();
            for (int i = 0; i < 6; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];
                int nh = now.h + dh[i];

                if (nr < 0 || nc < 0 || nh < 0 || nr >= n || nc >= m || nh >= h) continue;
                if (board[nh][nr][nc] == -1) continue;
                if (visited[nh][nr][nc]) continue;
                visited[nh][nr][nc] = true;
                board[nh][nr][nc] = board[now.h][now.r][now.c] + 1;
                q.add(new Point(nr, nc, nh));
            }
        }

        int ans = 0;
        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[k][i][j] == 0) {
                        System.out.println(-1);
                        return;
                    }

                    ans = Math.max(ans, board[k][i][j]);
                }
            }
        }

        System.out.println(ans-1);
    }
}

class Point {
    int r, c, h;

    public Point(int r, int c, int h) {
        this.r = r;
        this.c = c;
        this.h = h;
    }
}