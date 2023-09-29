package baekjoon.no2606;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int N, M;
    static int[][] graph;
    static boolean[] visited;
    static int cnt = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        graph = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        while (M-- > 0) {
            int src = sc.nextInt();
            int dst = sc.nextInt();

            graph[src][dst] = 1;
            graph[dst][src] = 1;
        }

//        dfs(1);
        bfs(1);
        System.out.println(cnt);
    }

    static void bfs(int node) {
        Queue<Integer> q = new LinkedList<>();
        visited[node] = true;
        q.add(node);

        while (!q.isEmpty()) {
            int now = q.poll();
            if (now != 1)
                cnt++;
            for (int i = 1; i <= N; i++) {
                if (graph[now][i] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }

    }

    static void dfs(int node) {
        visited[node] = true;
        for (int i = 1; i <= N; i++) {
            if (graph[node][i] == 1 && !visited[i]) {
                dfs(i);
                cnt++;
            }
        }
    }
}
