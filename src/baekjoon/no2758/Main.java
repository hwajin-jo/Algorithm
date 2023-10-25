package baekjoon.no2758;

import java.util.Scanner;

public class Main {

    static long[][] mem;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            mem = new long[n + 1][m + 1];

            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= m; j++) {
                    mem[i][j] = -1;
                }
            }

            System.out.println(solve(n, m));
        }
    }

    static long solve(int i, int last) {
        // base case
        if (last <= 0) return 0;
        if (i == 1) return last;

        // recursive case
        if (mem[i][last] == -1)
            mem[i][last] = solve(i - 1, last / 2) + solve(i, last - 1);

        return mem[i][last];
    }
}
