package baekjoon.no3;

import java.util.Scanner;


// 10026 - 적록색약
public class Main {

    public static int n;
    public static Character[][] board = new Character[101][101];
    public static boolean visited[][];
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};

    public static void dfs(int x, int y) {
        visited[x][y] = true;

        char now_color = board[x][y];
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            if (!visited[nx][ny] && board[nx][ny] == now_color) {
                dfs(nx, ny);
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        sc.nextLine(); // 버퍼 비우기
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        // nomal인 경우
        visited = new boolean[n+1][n+1];
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfs(i,j);
                    result += 1;
                }
            }
        }

        // 적록색약일 경우
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n ; j++) {
                if (board[i][j] == 'G') board[i][j] = 'R';
            }
        }

        visited = new boolean[n+1][n+1];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    count += 1;
                }
            }
        }

        System.out.println(result + " " + count);
    }
}
