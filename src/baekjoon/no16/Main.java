package baekjoon.no16;

import java.util.Scanner;

// 2167 - 이차원 배열의 합
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int k = sc.nextInt();

        for (int i = 0; i < k; i++) {
            int startX = sc.nextInt();
            int startY = sc.nextInt();

            int endX = sc.nextInt();
            int endY = sc.nextInt();

            startX--;
            startY--;

            int total = 0;
            for (int j = startX; j < endX; j++) {
                for (int l = startY; l < endY; l++) {
                    total += arr[j][l];
                }
            }

            System.out.println(total);
        }
    }
}
