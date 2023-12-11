package baekjoon.no17144;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static Queue<Dust> q;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] board;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        int c = sc.nextInt();
        int t = sc.nextInt();

        board = new int[r][c];

        int cleaner = -1;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                board[i][j] = sc.nextInt();
                if (cleaner == -1 && board[i][j] == -1) {
                    cleaner = i;
                }
            }
        }

        q = new LinkedList<>();
        while (t-- > 0) {
            // 미세먼지 정보 저장
            findDust(r, c, board);

            // 미세먼지 확산
            spreadDust(q, r, c);

            // 공기청전기 작동
           operating(cleaner, r, c);

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
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] > 0) {
                    q.add(new Dust(i, r, board[i][j]));
                }
            }
        }
    }

    static void spreadDust(Queue<Dust> q, int r, int c) {
        while (!q.isEmpty()) {
            Dust now = q.poll();

            int cnt = 0;
            int dust = now.w / 5;
            for (int i = 0; i < 4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];

                if (nr < 0 || nc < 0 || nr >= r || nc >= c) continue;
                if (board[nr][nc] == -1) continue;
                board[nr][nc] += dust;
                cnt++;
            }
            board[now.r][now.c] -= dust * cnt;
        }
    }

    static void operating(int cleaner, int r, int c) {
        int top = cleaner;
        int down = cleaner + 1;

        // 시계 방향
        for (int i = top - 1; i > 0; i--) {
            board[i][0] = board[i - 1][0];
        }

        for (int i = 1; i < c - 1; i++) {
            board[0][i] = board[0][i + 1];
        }

        for (int i = 0; i < top; i++) {
            board[i][c - 1] = board[i + 1][c - 1];
        }

        for (int i = c - 1; i > 1; i--) {
            board[top][i] = board[top][i - 1];
        }
        board[top][1] = 0;

        // 반시계 방향
        for (int i = down + 1; i < r - 1; i++) {
            board[i][0] = board[i + 1][0];
        }

        for (int i = 0; i < c - 1; i++) {
            board[r - 1][i] = board[r - 1][i + 1];
        }

        for (int i = r - 1; i > down; i--) {
            board[i][c - 1] = board[i - 1][c - 1];
        }

        for (int i = c - 1; i > 1; i--) {
            board[down][i] = board[down][i - 1];
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
