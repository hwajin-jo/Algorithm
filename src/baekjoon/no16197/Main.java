package baekjoon.no16197;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        char[][] board = new char[n][m];
        Queue<Point> q = new LinkedList<>();

        boolean flag = true;
        int r1 = 0, c1 = 0;

        for (int i = 0; i < n; i++) {
            String input = sc.next();
            for (int j = 0; j < m; j++) {
                board[i][j] = input.charAt(j);
                if (board[i][j] == 'o') {
                    if (flag) {
                        r1 = i;
                        c1 = j;
                        flag = false;
                    } else {
                        q.add(new Point(r1, c1, i, j, 0));
                    }
                }
            }
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        boolean[][][][] visited = new boolean[n][m][n][m];

        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr1 = now.r1 + dr[i];
                int nc1 = now.c1 + dc[i];
                int nr2 = now.r2 + dr[i];
                int nc2 = now.c2 + dc[i];

                int outside = 0;
                if (nr1 < 0 || nc1 < 0 || nr1 >= n || nc1 >= m) outside++;
                if (nr2 < 0 || nc2 < 0 || nr2 >= n || nc2 >= m) outside++;

                if (outside == 2) {
                    continue;
                } else if (outside == 1) {
                    if (now.cnt >= 10) {
                        System.out.println(-1);
                        System.exit(0);
                    } else {
                        System.out.println(now.cnt + 1);
                        System.exit(0);
                    }
                }

                if (board[nr1][nc1] == '#') {
                    nr1 = now.r1;
                    nc1 = now.c1;
                }

                if (board[nr2][nc2] == '#') {
                    nr2 = now.r2;
                    nc2 = now.c2;
                }

                if (outside == 0) {
                    if (visited[nr1][nc1][nr2][nc2]) continue;
                    visited[nr1][nc1][nr2][nc2] = true;
                    q.add(new Point(nr1, nc1, nr2, nc2, now.cnt + 1));
                }
            }
        }

        System.out.println(-1);

    }
}

class Point {
    int r1, c1;
    int r2, c2;

    int cnt = 0;
    public Point (int r1, int c1, int r2, int c2, int cnt) {
        this.r1 = r1;
        this.c1 = c1;
        this.r2 = r2;
        this.c2 = c2;
        this.cnt = cnt;
    }
}
