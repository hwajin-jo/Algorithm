package baekjoon.no3;

import java.util.Scanner;


// 10026 - 적록색약
public class Main {

    public static Character[][] board = new Character[101][101];
    public static boolean[][] visit;

    public static int n;
    public static int[] dx = { -1, 1, 0, 0 };
    public static int[] dy = { 0, 0, -1, 1 };

    public static void dfs(int x, int y) {
        visit[x][y] = true;
        char now_color = board[x][y];

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            if (!visit[nx][ny] && board[nx][ny] == now_color) {
                dfs(nx, ny);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        int nomal_cnt = 0;
        visit = new boolean[n+1][n+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j]) {
                    dfs(i, j);
                    nomal_cnt += 1;
                }
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'G') {
                    board[i][j] = 'R';
                }
            }
        }

        int non_cnt = 0;
        visit = new boolean[n+1][n+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j]) {
                    dfs(i, j);
                    non_cnt += 1;
                }
            }
        }

        System.out.println(nomal_cnt + " " + non_cnt);
    }
}
