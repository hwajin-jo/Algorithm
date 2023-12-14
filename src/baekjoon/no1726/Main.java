package baekjoon.no1726;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] map = new int[m + 1][n + 1];
        int[][][] visited = new int[5][m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k < 5; k++) {
                    visited[k][i][j] = -1;
                }
            }
        }

        Point start = new Point(sc.nextInt(), sc.nextInt(), sc.nextInt());
        Point end = new Point(sc.nextInt(), sc.nextInt(), sc.nextInt());

        int[] dr = {0, 0, 0, -1, 1};
        int[] dc = {0, -1, 1, 0, 0};
        final int EAST = 1 ,WEST = 2, SOUTH = 3, NORTH = 4;

        visited[start.d][start.r][start.c] = 0;
        Queue<Point> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            Point now = q.poll();

            // Go 명령
            for (int k = 1; k <= 3; k++) {
                int nr = now.r + dr[now.d] * k;
                int nc = now.c + dc[now.d] * k;

                if (!isRange(nr, nc, m, n)) break;
                if (map[nr][nc] == 1) break;
                if (visited[now.d][nr][nc] != -1) continue;
                visited[now.d][nr][nc] = visited[now.d][now.r][now.c] + 1;
                q.add(new Point(nr, nc, now.d));
            }

            // Turn 명령
            for (int k = 1; k <= 4; k++) {
                if (k == now.d) continue;
                if (visited[k][now.r][now.c] != -1) continue;
                int cnt;
                if (k == EAST || k == WEST) {
                    cnt = (now.d == SOUTH || now.d == NORTH) ? 1 : 2;
                } else if (k == SOUTH || k == NORTH) {
                    cnt = (now.d == EAST || now.d == WEST) ? 1 : 2;
                } else {
                    cnt = 0;
                }
                visited[k][now.r][now.c] = visited[now.d][now.r][now.c] + cnt;
                q.add(new Point(now.r, now.c, k));
            }
        }

        System.out.println(visited[end.d][end.r][end.c]);
    }

    static boolean isRange(int r, int c, int m, int n) {
        return r > 0 && c > 0 && r <= m && c <= n;
    }
}

class Point {
    int r, c, d;
    public Point (int r, int c, int d) {
        this.r = r;
        this.c = c;
        this.d = d;
    }
}
