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
        int[][][] dist = new int[5][m + 1][n + 1];

        final int EAST = 1, WEST = 2, SOUTH = 3, NORTH = 4;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        Point start = new Point(sc.nextInt(), sc.nextInt(), sc.nextInt());
        Point end = new Point(sc.nextInt(), sc.nextInt(), sc.nextInt());

        int[] dr = {0, 0, 0, 1, -1};
        int[] dc = {0, 1, -1, 0, 0};

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= 4; k++) {
                    dist[k][i][j] = -1;
                }
            }
        }

        dist[start.dir][start.r][start.c] = 0;
        Queue<Point> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) { // 전진 할 때에 로직
            Point now = q.poll();
            for (int k = 1; k <= 3; k++) {
                int nr = now.r + dr[now.dir] * k;
                int nc = now.c + dc[now.dir] * k;
                if (!isRange(nr, nc, m, n)) break;
                if (map[nr][nc] == 1) break;
                if (dist[now.dir][nr][nc] != -1) continue;
                dist[now.dir][nr][nc] = dist[now.dir][now.r][now.c] + 1;
                q.add(new Point(nr, nc, now.dir));
            }

            for (int k = 1; k <= 4; k++) { // 회전 할 때의 로직
                if (k == now.dir) continue;
                if (dist[k][now.r][now.c] != -1) continue;
                int cnt;
                if (k == EAST || k == WEST) {
                    cnt = (now.dir == NORTH || now.dir == SOUTH) ? 1 : 2;
                } else if (k == SOUTH || k == NORTH) {
                    cnt = (now.dir == EAST || now.dir == WEST) ? 1 : 2;
                } else {
                    cnt = 0;
                }

                dist[k][now.r][now.c] = dist[now.dir][now.r][now.c] + cnt;
                q.add(new Point(now.r, now.c, k));
            }
        }

        System.out.println(dist[end.dir][end.r][end.c]);
    }

    static boolean isRange(int r, int c, int m, int n) {
        return r >= 1 && r <= m && c >= 1 && c <= n;
    }
}

class Point {
    int r, c, dir;

    Point(int r, int c, int dir) {
        this.r = r;
        this.c = c;
        this.dir = dir;
    }
}