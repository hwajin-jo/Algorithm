package baekjoon.no11047;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] d = new int[100000001]; // i의 합을 위한 최소 동전의 갯수
        Arrays.fill(d, Integer.MAX_VALUE);

        int[] coins = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            coins[i] = sc.nextInt();
            d[coins[i]] = 1;
        }
        d[0] = 0;

        int min = d[1];
        for (int i = 2; i <= k; i++) {
            d[i] = Math.min(d[i], Math.min(d[min] * (i / min) + d[i % min], d[i - 1] + 1));
            if (d[i] == 1)
                min = i;
        }

        System.out.println(d[k]);
    }
}
