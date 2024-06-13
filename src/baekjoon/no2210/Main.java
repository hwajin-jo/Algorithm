package baekjoon.no2210;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static final int size = 5;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static Set<Integer> set;
    static int[][] board;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        board = new int[size][size];
        set = new HashSet<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                dfs(i, j, board[i][j], 1);
            }
        }

        System.out.println(set.size());
    }

    static void dfs (int r, int c, int num, int cnt) {
        if (cnt == 6) {
            set.add(num);
            return;
        }

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nc < 0 || nr >= size || nc >= size) continue;
            dfs(nr, nc, num * 10 + board[nr][nc], cnt+1);
        }
    }
}
