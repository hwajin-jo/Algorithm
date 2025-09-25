package baekjoon.no16173;

import java.util.Scanner;

public class Main {

    static int[] dr = {0, 1};
    static int[] dc = {1, 0};
    static int[][] arr;
    static boolean[][] visited;
    static int N;
    static boolean isFinish = false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        arr = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        visited[0][0] = true;
        dfs(0 , 0);

        if (!isFinish)
            System.out.println("Hing");
        else
            System.out.println("HaruHaru");
    }

    public static void dfs(int r, int c) {
        if (r == N - 1 && c == N - 1) {
            isFinish = true;
            return;
        }

        int step = arr[r][c];
        for (int i = 0; i < 2; i++) {
            int nr = r + dr[i] * step;
            int nc = c + dc[i] * step;
            if (nr >= N || nc >= N)
                continue;
            if (visited[nr][nc])
                continue;
            visited[nr][nc] = true;
            dfs(nr, nc);
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
