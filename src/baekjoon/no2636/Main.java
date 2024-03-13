package baekjoon.no2636;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n, m;
    static int[][] board;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static Queue<Point> q;
    static int cheese;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        board = new int[n][m];
        visited = new boolean[n][m];

        cheese = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = sc.nextInt();

                if (board[i][j] == 1) cheese++;
            }
        }

        int time = 0;
        int cheeseCount = 0;
        while (cheese != 0) {
            cheeseCount = cheese;
            visited = new boolean[n][m];
            melting();
            time++;
        }
        System.out.println(time);
        System.out.println(cheeseCount);
    }
    static void melting() {
        q= new LinkedList<>();
        q.add(new Point(0, 0));
        visited[0][0] = true;
        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];

                if (nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
                if (visited[nr][nc]) continue;
                visited[nr][nc] = true;
                if (board[nr][nc] == 0) {
                    q.add(new Point(nr, nc));
                } else {
                    board[nr][nc] = 0;
                    cheese--;
                }
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
