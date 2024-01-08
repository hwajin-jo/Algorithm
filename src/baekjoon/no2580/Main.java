package baekjoon.no2580;

import java.util.Scanner;

public class Main {

    static int[][] arr = new int[9][9];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        sudoku(0, 0);
    }

    static void sudoku(int row, int col) {
        if (col == 9) { // 한 행을 다 탐색했으면 다음 행으로 이동
            sudoku(row + 1, 0);
            return;
        }

        if (row == 9) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }

            // 출력 뒤 시스템을 종료한다.
            System.exit(0);
        }

        if (arr[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (isPossible(row, col, i)) {
                    arr[row][col] = i;
                    sudoku(row, col + 1);
                }
            }
            arr[row][col] = 0;
            return;
        }

        sudoku(row, col + 1);
    }

    static boolean isPossible(int row, int col, int val) {
        for (int i = 0; i < 9; i++) {
            if (arr[row][i] == val) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (arr[i][col] == val) {
                return false;
            }
        }

        int set_row = (row / 3) * 3;
        int set_col = (row / 3) * 3;

        for (int i = set_row; i < set_row + 3; i++) {
            for (int j = set_col; j < set_col + 3; j++) {
                if (arr[i][j] == val)
                    return false;
            }
        }

        return true;
    }
}
