package baekjoon.no4485;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int test_case = 0;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            if (n == 0) break;
            test_case++;

            int[][] arr = new int[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; st.hasMoreTokens(); j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] res = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    res[i][j] = Integer.MAX_VALUE;
                }
            }

            Queue<Point> q = new LinkedList<>();
            q.add(new Point(0, 0));
            res[0][0] = arr[0][0];
            while (!q.isEmpty()) {
                Point now = q.poll();

                for (int i = 0; i < 4; i++) {
                    int nr = now.r + dr[i];
                    int nc = now.c + dc[i];

                    if (nr < 0 || nc < 0 || nr >= n || nc >= n) continue;

                    if (res[nr][nc] > res[now.r][now.c] + arr[nr][nc]) {
                        res[nr][nc] = res[now.r][now.c] + arr[nr][nc];
                        q.add(new Point(nr, nc));
                    }
                }
            }

            bw.write("Problem " + test_case + ": " + res[n - 1][n - 1]);
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}

class Point {
    int r, c;

    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
