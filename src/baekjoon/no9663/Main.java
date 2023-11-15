package baekjoon.no9663;

import java.util.Scanner;

public class Main {

    static int N;
    static int ans = 0;
    static boolean[][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        visited = new boolean[N][N];

        solve(0);

        System.out.println(ans);

//        System.out.println(solve(0));
    }

    static void solve(int row) {
        if (row == N) {
            ans++;
            return;
        }

        for (int col = 0; col < N; col++) {
            if (isValid(row, col)) {
                visited[row][col] = true;
                solve(row + 1);
                visited[row][col] = false;
            }
        }
    }

    static boolean isValid(int row, int col) {
        // 같은 열 방향 검사
        for (int i = 0; i < row; i++) {
            if (visited[i][col]) return false;
        }

        // / 대각선 검사
        int tempR = row;
        int tempC = col;
        while ((0 <= tempR && tempR < N) && (0 <= tempC && tempC < N)) {
            if (visited[tempR--][tempC++]) return false;
        }

        // \ 대각선 검사
        while ((0 <= row && row <= N) && (0 <= col && col < N)) {
            if (visited[row--][col--]) return false;
        }

        return true;
    }
//
//    static int solve(int row) {
//        int count = 0;
//        // base case
//        if (row == N) {
//            return 1;
//        }
//        // recursive case
//        for (int col = 0; col < N; col++) {
//            if (isValid(row, col)) {
//                queen[row] = col;
//                count += solve(row + 1);
//            }
//        }
//
//        return count;
//    }
//
//    static boolean isValid(int row, int col) {
//        for (int i = 0; i < row; i++) {
//            if (queen[i] == col) return false;
//            if (Math.abs(row - i) == Math.abs(queen[i] - col)) return false;
//        }
//
//        return true;
//    }

}

