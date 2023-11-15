package baekjoon.no9663;

import java.util.Scanner;

public class Main {

    static int N;
    static int ans = 0;
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
    static int[][] board;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board = new int[N][N];
                visited = new boolean[N][N];
                if (!visited[i][j]) {
                    solve(0, new Point(i, j));
                }
            }
        }

        System.out.println(ans);
    }

    static void solve(int cnt, Point now) {
        // base_case
        if (cnt == N) {
            ans++;
            return;
        }

//        if (now.x < 0 || now.y < 0 || now.x >= N || now.y >= N) return;
        if (now.x == N - 1 && now.y == N - 1)
            return;
        if (now.x == N)
            return;

        if (now.y == N) {
            solve(cnt, new Point(now.x + 1, 0));
            return;
        }


        // recursive_case


        if (board[now.x][now.y] == 0 && !visited[now.x][now.y]) {
            board[now.x][now.y] = 1;
            visited[now.x][now.y] = true;
            check(new Point(now.x, now.y), true); // 현재 퀸의 영역표시
            solve(cnt + 1, new Point(now.x, now.y + 1));
            check(now, false);
            visited[now.x][now.y] = false;
            board[now.x][now.y] = 0;
        } else {
            solve(cnt, new Point(now.x, now.y + 1));
        }

//        for (int i = now.x; i < N; i++) {
//            for (int j = now.y; j < N; j++) {
//
//            }
//        }


    }

    static void check(Point now, boolean status) {
        for (int i = 0; i < 8; i++) {
            int nx = now.x;
            int ny = now.y;
            while (true) {
                nx = nx + dx[i];
                ny = ny + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) break;
                if (visited[nx][ny]) continue;
                visited[nx][ny] = status;
            }
        }
    }
}

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
