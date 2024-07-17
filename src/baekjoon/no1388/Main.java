package baekjoon.no1388;

import java.util.Scanner;

public class Main {

    static int n, m;
    static char[][] board;
    static boolean[][] visited;
    static char shape;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        board = new char[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            board[i] = sc.next().toCharArray();
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    shape = board[i][j];
                    solve(i, j);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }

    static void solve(int r, int c) {
        visited[r][c] = true;

        if (shape == '-' && c < m - 1 && shape == board[r][c + 1]) {
            solve(r, c + 1);
        }


        if (shape == '|' && r < n - 1 && shape == board[r + 1][c]) {
            solve(r + 1, c);
        }
    }
}
