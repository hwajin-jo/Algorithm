package baekjoon.no14501;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] d = new int[n + 2]; // n번째 날부터 퇴사일까지 얻을수 있는 최대 이익

        int[][] consulting = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            consulting[i][0] = sc.nextInt();
            consulting[i][1] = sc.nextInt();
        }

        for (int i = n; i > 0; i--) {
            int period = consulting[i][0];
            int benefit = consulting[i][1];

            if (i + period > n + 1) d[i] = d[i + 1];
            else d[i] = Math.max(d[i + 1], d[i + period] + benefit);
        }

        System.out.println(d[1]);
    }
}
