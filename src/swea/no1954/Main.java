package swea.no1954;

import java.util.Scanner;

public class Main {
    static int[] dx = {0, 1, 0, -1}; // 우 하 좌 상
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int[][] board = new int[N][N];

            snailNumber(board, 0, 0, N);
            printNumber(test_case, board);
        }
    }

    static void snailNumber(int[][] board, int x, int y, int N) {
        int count = 1;
        board[x][y] = count++;

        int i = 0;
        while (!finish(board)) {
            while (true) {
                if (i == 4) i = 0;

                x += dx[i];
                y += dy[i];

                if ((x < 0 || y < 0 || x >= N || y >= N) || board[x][y] != 0) {
                    x -= dx[i];
                    y -= dy[i];
                    break;
                }

                board[x][y] = count++;
            }
            i++;
        }
    }

    static boolean finish(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0) return false;
            }
        }

        return true;
    }

    static void printNumber(int t, int[][] board) {
        System.out.println("#" + t);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
