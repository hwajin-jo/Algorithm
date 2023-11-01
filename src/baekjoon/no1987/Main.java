package baekjoon.no1987;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    static int R, C;
    static char[][] board;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static Set<Character> set;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();

        board = new char[R][C];
        visited = new boolean[R][C];
        set = new HashSet<>();
        for (int i = 0; i < R; i++) {
            String input = sc.next();
            for (int j = 0; j < C; j++) {
                board[i][j] = input.charAt(j);
            }
        }

        visited[0][0] = true;
        set.add(board[0][0]);
        dfs(new Point(0, 0));

        System.out.println(set.size());
    }

    static void dfs(Point now) {
        for (int i = 0; i < 4; i++) {
            int nr = now.r + dr[i];
            int nc = now.c + dc[i];

            if (nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
            if (visited[nr][nc]) continue;

            visited[nr][nc] = true;
            if (!set.contains(board[nr][nc])) {

                dfs(new Point(nr, nc));
                set.add(board[nr][nc]);
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
