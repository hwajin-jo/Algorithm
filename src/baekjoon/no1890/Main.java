package baekjoon.no1890;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        int[][] arr = new int[N][N];
        long[][] dp = new long[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        dp[0][0] = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == N - 1 && j == N - 1) break;
                if (dp[i][j] != 0) {
                    int nextD = i + arr[i][j];
                    if (nextD < N) {
                        dp[nextD][j] += dp[i][j];
                    }

                    int nextR = j + arr[i][j];
                    if (nextR < N) {
                        dp[i][nextR] += dp[i][j];
                    }
                }

            }
        }

        System.out.println(dp[N - 1][N - 1]);
    }

    public static boolean isValid(int nx, int ny) {
        return 0 <= nx && nx < N && 0 <= ny && ny < N;
    }
}

class Point {
    int x;
    int y;
    int step;

    public Point(int x, int y, int step) {
        this.x = x;
        this.y = y;
        this.step = step;
    }
}
