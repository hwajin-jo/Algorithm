package baekjoon.no17484;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int n, m;
    static int[][] arr;
    static int[] dir = {-1, 0, 1};
    static int ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        ans = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            dfs(0, i, 0, 0);
        }


        System.out.println(ans);
    }

    static void dfs(int r, int c, int d, int sum) {
        if (r == n) {
            ans = Math.min(ans, sum);
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (d == i) continue;
            int nc = c + dir[i];
            if (0 <= nc && nc < m) {
                dfs(r + 1, nc, i, sum + arr[r][nc]);
            }
        }
    }
}
