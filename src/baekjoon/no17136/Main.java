package baekjoon.no17136;

import java.util.Scanner;

public class Main {

    static int[][] board;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        board = new int[10][10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                board[i][j] = sc.nextInt();
            }
        }


    }
}
