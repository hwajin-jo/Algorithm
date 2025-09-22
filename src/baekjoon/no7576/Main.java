package baekjoon.no7576;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] arr = new int[n][m];
        boolean[][] visitied = new boolean[n][m];

        Queue<Point> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] == 1) {
                    q.add(new Point(i, j));
                    visitied[i][j] = true;
                }
            }
        }

        boolean isZero = false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    isZero = true;
                }
            }
        }

        if (!isZero) {
            System.out.println(0);
            return;
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];

                if (nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
                if (arr[nr][nc] != 0) continue;
                if (!visitied[nr][nc]) {
                    visitied[nr][nc] = true;
                    arr[nr][nc] = arr[now.r][now.c] + 1;
                    q.add(new Point(nr, nc));
                }
            }
        }

        int days = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                days = Math.max(days, arr[i][j]);
            }
        }

        System.out.println(days - 1);
    }
}

class Point {
    int r, c;

    public Point (int r, int c) {
        this.r = r;
        this.c = c;
    }
}