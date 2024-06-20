package baekjoon.no27211;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] planet;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        planet = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                planet[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (planet[i][j] == 0 && !visited[i][j]) {
                    cnt++;
                    bfs(i, j);
                }
            }
        }

        System.out.println(cnt);
    }

    static void bfs(int r, int c) {
        visited[r][c] = true;
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(r, c));

        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = (now.r + dr[d] + n) % n;
                int nc = (now.c + dc[d] + m) % m;

                if (visited[nr][nc]) continue;
                if (planet[nr][nc] == 1) continue;
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
