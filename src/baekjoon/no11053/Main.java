package baekjoon.no11053;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n + 1];
        int[] d = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            d[i] = 1;
            for (int j = 1; j < i; j++) {
                if (arr[j] > arr[i]) continue;
                d[i] = Math.max(d[i], d[j] + 1);
                max = Math.max(d[i], max);
            }
        }

        System.out.println(max);
    }
}
