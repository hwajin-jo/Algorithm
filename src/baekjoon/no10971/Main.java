package baekjoon.no10971;

import java.util.Scanner;

public class Main {

    static int[][] W;
    static boolean[] visited;
    static int N;

    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        W = new int[N][N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                W[i][j] = sc.nextInt();
            }
        }

        bt(0, 0, 0, 0);
        System.out.println(ans);
    }

    static void bt(int start, int node, int sum, int depth) {
        if (depth == N && node == start) {
            ans = Math.min(ans, sum);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i] && W[node][i] > 0) {
                visited[i] = true;
                bt(start, i, sum + W[node][i], depth + 1);
                visited[i] = false;
            }
        }
    }

}
