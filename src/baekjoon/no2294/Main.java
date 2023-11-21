package baekjoon.no2294;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] coin = new int[n + 1];
        int[] d = new int[100001];
        Arrays.fill(d, 100001);

        for (int i = 1; i <= n; i++) {
            coin[i] = sc.nextInt();
            if (coin[i] <= k)
                d[coin[i]] = 1;
        }

        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                if (i - coin[j] >= 0)
                    d[i] = Math.min(d[i], d[i - coin[j]] + 1);
            }
        }

        if (d[k] == 100001)
            System.out.println(-1);
        else
            System.out.println(d[k]);
    }
}
