package baekjoon.no1743;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        int[][] arr = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < k; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            arr[r - 1][c - 1] = 1;
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        int max = 0;


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) {
                    Queue<Point> q = new LinkedList<>();
                    q.add(new Point(i, j));
                    visited[i][j] = true;
                    int cnt = 0;

                    while (!q.isEmpty()) {
                        Point now = q.poll();
                        cnt++;

                        for (int d = 0; d < 4; d++) {
                            int nr = now.r + dr[d];
                            int nc = now.c + dc[d];

                            if (nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
                            if (visited[nr][nc]) continue;
                            if (arr[nr][nc] == 0) continue;
                            visited[nr][nc] = true;
                            q.add(new Point(nr, nc));
                        }
                    }
                    max = Math.max(cnt, max);
                }
            }
        }

        System.out.println(max);
    }
}

class Point {
    int r, c;

    public Point (int r, int c) {
        this.r = r;
        this.c = c;
    }
}
