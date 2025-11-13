package baekjoon.no9251;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] arrA = sc.next().toCharArray();
        char[] arrB = sc.next().toCharArray();

        int lenA = arrA.length;
        int lenB = arrB.length;
        int[][] dp = new int[lenA + 1][lenB + 1];

        for (int i = 1; i <= arrA.length; i++) {
            for (int j = 1; j <= arrB.length; j++) {
                if (arrA[i - 1] == arrB[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        System.out.println(dp[lenA][lenB]);
    }
}
