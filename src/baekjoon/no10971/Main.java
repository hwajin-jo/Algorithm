package baekjoon.no10971;

import java.util.Scanner;

public class Main {

    static int[][] w;
    static boolean[] visited;
    static int N;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        w = new int[N][N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                w[i][j] = sc.nextInt();
            }
        }

        dfs(0, 0, 0, 0);

        System.out.println(ans);
    }

    static void dfs(int start, int node, int sum, int depth) {
        if (depth == N && start == node) {
            ans = Math.min(ans, sum);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i] && w[node][i] != 0) {
                visited[i] = true;
                dfs(start, i, sum + w[node][i], depth + 1);
                visited[i] = false;
            }
        }
    }
}
