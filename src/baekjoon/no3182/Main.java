package baekjoon.no3182;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int ans, max;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine()) - 1;
        }

        ans = 0;
        max = 0;
        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            dfs(i, 1, i);
        }

        System.out.println(ans + 1);
    }

    static void dfs (int now, int sum, int start) {
        if (visited[now]) return;
        if (sum > max) {
            ans = start;
            max = sum;
        }
        visited[now] = true;
        dfs(arr[now], sum+1, start);
    }
}
