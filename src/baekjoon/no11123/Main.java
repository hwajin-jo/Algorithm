package baekjoon.no11123;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int n, m;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            n = sc.nextInt();
            m = sc.nextInt();

            char[][] arr = new char[n][m];
            boolean[][] visited = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.next().toCharArray();
            }

            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] == '#' && !visited[i][j]) {
                        cnt++;
                        visited[i][j] = true;
                        bfs(i, j, arr, visited);
                    }
                }
            }

            System.out.println(cnt);
        }
    }

    static void bfs(int r, int c, char[][] arr, boolean[][] visited) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(r, c));
        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];

                if (nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
                if (visited[nr][nc]) continue;
                if (arr[nr][nc] == '.') continue;
                visited[nr][nc] = true;
                q.add(new Point(nr, nc));
            }
        }
    }
}

class Point {
    int r, c;
    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
