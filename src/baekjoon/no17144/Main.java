package baekjoon.no17144;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static ArrayList<Integer> cleaner;
    static Queue<Dust> q;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] board;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        int c = sc.nextInt();
        int t = sc.nextInt();

        cleaner = new ArrayList<>();
        board = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                board[i][j] = sc.nextInt();
                if (board[i][j] == -1) {
                    cleaner.add(i);
                }
            }
        }

        while (t-- > 0) {
            // 미세먼지 정보 저장
            findDust(r, c, board);

            // 미세먼지 확산
            spreadDust(r, c);

            // 공기청전기 작동
           operating(r, c);
        }

        int ans = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == -1) continue;
                ans += board[i][j];
            }
        }

        System.out.println(ans);
    }

    static void findDust(int r, int c, int[][] board) {

        q = new LinkedList<>();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == -1 || board[i][j] == 0) continue;
                q.add(new Dust(i, j, board[i][j]));
            }
        }
    }

    static void spreadDust(int r, int c) {
        while (!q.isEmpty()) {
            Dust now = q.poll();

            if (now.w < 5) continue;

            int cnt = 0;
            int dust = now.w / 5;
            for (int i = 0; i < 4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];

                if (nr < 0 || nc < 0 || nr >= r || nc >= c) continue;
                if (board[nr][nc] == -1) continue;
                board[nr][nc] += dust;
                ++cnt;
            }
            board[now.r][now.c] -= dust * cnt;
        }
    }

    static void operating(int r, int c) {
        int top = cleaner.get(0);
        int down = cleaner.get(1);

        // 반시계 방향
        for (int x = top - 1; x > 0; x--) {
            board[x][0] = board[x - 1][0];
        }

        for (int y = 0; y < c - 1; y++) {
            board[0][y] = board[0][y + 1];
        }

        for (int x = 0; x < top; x++) {
            board[x][c - 1] = board[x + 1][c - 1];
        }

        for (int y = c - 1; y > 1; y--) {
            board[top][y] = board[top][y - 1];
        }
        board[top][1] = 0;

        // 시계 방향
        for (int x = down + 1; x < r - 1; x++) {
            board[x][0] = board[x + 1][0];
        }

        for (int y = 0; y < c - 1; y++) {
            board[r - 1][y] = board[r - 1][y + 1];
        }

        for (int x = r - 1; x > down; x--) {
            board[x][c - 1] = board[x - 1][c - 1];
        }

        for (int y = c - 1; y > 1; y--) {
            board[down][y] = board[down][y - 1];
        }
        board[down][1] = 0;
    }
}

class Dust {
    int r, c, w;
    public Dust(int r, int c, int w) {
        this.r = r;
        this.c = c;
        this.w = w;
    }
}
