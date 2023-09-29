package baekjoon.no19951;

import java.util.Scanner;

public class Main {

    /*
    10 3
    1 2 3 4 5 -1 -2 -3 -4 -5
    1 5 -3
    6 10 5
    2 7 2
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] origin = new int[n+1];

        for (int i = 1; i <= n; i++) {
            origin[i] = sc.nextInt();
        }

        int[] delta = new int[n+2];
        while (m-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int k = sc.nextInt();

            delta[a] += k;
            delta[b+1] -= k;
        }

        int[] acc_delta = new int[n+1];
        for (int i = 1; i <= n; i++) {
            acc_delta[i] = acc_delta[i-1] + delta[i];
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(origin[i] + acc_delta[i] + " ");
        }
        System.out.println();

    }
}
