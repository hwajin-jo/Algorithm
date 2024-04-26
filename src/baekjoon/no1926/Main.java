package baekjoon.no1926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] paints = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                paints[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        int cnt = 0;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (paints[i][j] == 1 && !visited[i][j]) {
                    cnt++;
                    visited[i][j] = true;

                    Queue<Point> q = new LinkedList<>();
                    q.add(new Point(i, j));

                    int width = 1;
                    while (!q.isEmpty()) {
                        Point now = q.poll();

                        for (int d = 0; d < 4; d++) {
                            int nr = now.r + dr[d];
                            int nc = now.c + dc[d];

                            if (nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
                            if (visited[nr][nc]) continue;
                            if (paints[nr][nc] == 0) continue;
                            visited[nr][nc] = true;
                            q.add(new Point(nr, nc));
                            width++;
                        }
                    }

                    ans = Math.max(ans, width);
                }
            }
        }

        System.out.println(cnt);
        System.out.println(ans);
    }
}

class Point {
    int r, c;
    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
