package baekjoon.no9663;

import java.util.Scanner;

public class Main {

    static int[] nqueen = new int[15];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
    }

    static int solve(int n, int row) {
        int count = 0;

        // base case
        if (row == n) {
            return 1;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(row, col)) {
                nqueen[row] = col;
                count += solve(n, row + 1);
                nqueen[row] = 0;
            }
        }

        return count;
    }

    static boolean isValid(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (nqueen[i] == col) return false;
            if (Math.abs(row - i) == Math.abs(nqueen[i] - col)) return false;
        }

        return true;
    }



}

