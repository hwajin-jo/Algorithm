package baekjoon.no2589;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static char[][] maps;
    static boolean[][] visited;
    static int n, m;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        maps = new char[n][m];
        for (int i = 0; i < n; i++) {
            String input = sc.next();
            for (int j = 0; j < input.length(); j++) {
                maps[i][j] = input.charAt(j);
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i][j] == 'L') {
                    visited = new boolean[n][m];
                    int res = bfs(i, j);
                    ans = Math.max(res, ans);
                }

            }
        }

        System.out.println(ans);
    }

    static int bfs(int r, int c) {
        Queue<Point> q= new LinkedList<>();
        q.add(new Point(r, c, 0));
        visited[r][c] = true;

        int max = 0;
        while (!q.isEmpty()) {
            Point now = q.poll();
            max = Math.max(max, now.t);

            for (int i = 0; i < 4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];

                if (nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
                if (visited[nr][nc]) continue;
                if (maps[nr][nc] == 'W') continue;
                visited[nr][nc] = true;
                q.add(new Point(nr, nc, now.t + 1));
            }
        }

        return max;
    }
}

class Point {
    int r, c, t;

    public Point (int r, int c, int t) {
        this.r = r;
        this.c = c;
        this.t = t;
    }
}
