package baekjoon.no1730;

import java.util.Scanner;

public class Main {

    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        sc.nextLine();
        String move = sc.nextLine();

        char[][] board = new char[n][n];

        boolean[][] visitHorizontal = new boolean[n][n];
        boolean[][] visitVertical = new boolean[n][n];

        int Row = 0;
        int Col = 0;

        for (int i = 0; i < move.length(); i++) {
            char step = move.charAt(i);

            if (step == 'L') {
                if (Col == 0) continue;
                visitVertical[Row][Col] = visitVertical[Row][Col-1] = true;
                Col--;
            } else if (step == 'R') {
                if (Col == n-1) continue;
                visitVertical[Row][Col] = visitVertical[Row][Col+1] = true;
                Col++;
            } else if (step == 'U') {
                if (Row == 0) continue;
                visitHorizontal[Row][Col] = visitHorizontal[Row-1][Col] = true;
                Row--;
            } else if (step == 'D') {
                if (Row == n-1) continue;
                visitHorizontal[Row][Col] = visitHorizontal[Row+1][Col]  = true;
                Row++;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visitHorizontal[i][j] && visitVertical[i][j]) board[i][j] = '+';
                else if (visitHorizontal[i][j] && !visitVertical[i][j]) board[i][j] = '|';
                else if (!visitHorizontal[i][j] && visitVertical[i][j]) board[i][j] = '-';
                else board[i][j] = '.';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

}