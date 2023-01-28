package baekjoon.no4;

import java.util.Scanner;

// 2468 - 안전 영역
public class Main {

    public static int n;
    public static int[][] board;
    public static int[][] copy_board;
    public static boolean dfs(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= n) return false;
        if (copy_board[x][y] == 0) {
            copy_board[x][y] = 1; // 방문처리
            dfs(x+1, y);
            dfs(x-1, y);
            dfs(x, y+1);
            dfs(x, y-1);
            return true;
        }

        return false;
    }

    public static void copy() {
        for(int i=0; i< n; i++){
            for(int j=0; j < n; j++){
                copy_board[i][j] = board[i][j];
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        board = new int[n+1][n+1];
        copy_board = new int[n+1][n+1];
        int maxHeight = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
                maxHeight = Math.max(maxHeight, board[i][j]);
            }
        }

        int max = Integer.MIN_VALUE;
        for (int h = 0; h <= maxHeight; h++) {
            copy(); // 테스트 할 배열 초기화
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (copy_board[i][j] <= h) {
                        copy_board[i][j] = 1;
                    } else {
                        copy_board[i][j] = 0;
                    }
                }
            }
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dfs(i, j)) {
                        cnt += 1;
                    }
                }
            }
            max = Math.max(cnt, max);
        }

        System.out.println(max);
    }
}
