package baekjoon.no12100;

import java.util.Scanner;

public class Main {

    static int n;
    static int ans = 0;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        solve(0, map);

        System.out.println(ans);
    }

    static void solve(int cnt, int[][] map) {

        int[][] newMap = copyMap(map);

        if (cnt == 5) {
            ans = Math.max(ans, getMaxBlock(map));
            return;
        }

        for (int d = 0; d < 4; d++) {
            move(d, newMap);
            solve(cnt + 1, newMap);
        }

    }

    static int[][] copyMap(int[][] map) {
        int[][] temp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = map[i][j];
            }
        }

        return temp;
    }

    static int[][] move(int d, int[][] map) {
        boolean[][] check = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int nr = i + dr[d];
                int nc = j + dc[d];

                if (nr < 0 || nc < 0 || nr >= n || nc >= n) continue;
                if (check[nr][nc]) continue;
                if (map[nr][nc] > 0 && map[nr][nc] == map[i][j]) {
                    map[nr][nc] = map[i][j] * 2;
                    map[i][j] = 0;
                    check[nr][nc] = true;
                } else if (map[nr][nc] == 0){
                    map[nr][nc] = map[i][j];
                    map[i][j] = 0;
                    check[nr][nc] = true;
                }
            }
        }

        return map;
    }

    static int getMaxBlock(int[][] board) {
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, board[i][j]);
            }
        }
        return max;
    }
}
