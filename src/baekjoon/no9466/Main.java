package baekjoon.no9466;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    static int[] graph;
    static boolean[] visited;
    static boolean[] finish;
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            graph = new int[N + 1];
            visited = new boolean[N + 1];
            finish = new boolean[N + 1];
            ans = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                graph[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= N; i++) {
                if (finish[i]) continue;
                dfs(i);
            }

            System.out.println(N - ans);
        }
    }

    static void dfs(int nodeIdx) {
        if (finish[nodeIdx]) return;

        if (visited[nodeIdx]) { // 방문한 적이 있으면 사이클이 만들어진 것
            finish[nodeIdx] = true; // 다음번엔 찾아올 필요 없음
            ans++; // 사이클에 포함되는 갯수 추가
        }
        visited[nodeIdx] = true;
        dfs(graph[nodeIdx]);
        finish[nodeIdx] = true;
    }
}
