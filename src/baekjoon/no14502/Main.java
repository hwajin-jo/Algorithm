package baekjoon.no14502;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int ans;
    static int n, m;
    static int[][] map;
    static int[][] origin;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static Queue<Point> q;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        origin = new int[n][m];
        map = new int[n][m];
        q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                origin[i][j] = sc.nextInt();

                if (origin[i][j] == 2)
                    q.add(new Point(i, j));
            }
        }

        ans = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copyData();
                makeWall(0, i, j);
            }
        }

        System.out.println(ans);
    }

    static void copyData() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = origin[i][j];
            }
        }
    }

    static void makeWall(int cnt, int r, int c) {
        if (cnt == 3) {
            spreadVirus();
            ans = Math.max(ans, countSafeArea());
            return;
        }

        if (r == n)
            return;

        if (c == m)
            makeWall(cnt, r + 1, 0);

        if (r < n && c < m) {
            if (map[r][c] == 0) {
                map[r][c] = 1;
                makeWall(cnt + 1, r, c + 1);
            } else {
                makeWall(cnt, r, c + 1);
            }
        }
    }

    static void spreadVirus() {
        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];

                if (nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
                if (map[nr][nc] == 0) {
                    map[nr][nc] = 2;
                    q.add(new Point(nr, nc));
                }
            }
        }
    }

    static int countSafeArea() {
        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) result++;
            }
        }

        return result;
    }
}

class Point {
    int r, c;

    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}