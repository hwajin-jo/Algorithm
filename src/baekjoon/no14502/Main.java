package baekjoon.no14502;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int ans;
    static int n, m;
    static int[][] map;
    static int[][] originMap;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static Queue<Point> q;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        originMap = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                originMap[i][j] = sc.nextInt();
            }
        }

        ans = -1;
        makeWall(0);

        System.out.println(ans);
    }

    static void makeWall(int cnt) {
        if (cnt == 3) {
            spreadVirus();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (originMap[i][j] == 0) {
                    originMap[i][j] = 1;
                    makeWall(cnt + 1);
                    originMap[i][j] = 0;
                }
            }
        }
    }

    static void spreadVirus() {
        q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (originMap[i][j] == 2)
                    q.add(new Point(i, j));
            }
        }

        for (int i = 0; i < n; i++) {
            map[i] = originMap[i].clone();
        }

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

        ans = Math.max(ans, countSafeArea());
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