package baekjoon.no1260;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static boolean[][] graph;
    static boolean[] visited;

    static int N, M, V;

    static int[] result;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();

        graph = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();

            graph[node1][node2] = graph[node2][node1] = true;
        }

        result = new int[N + 1];
        dfs(V);
        System.out.println();
        visited = new boolean[N + 1];
        bfs(V);
    }

    static void dfs(int node) {
        visited[node] = true;
        System.out.print(node + " ");
        for (int i = 1; i <= N; i++) {
            if (graph[node][i] && !visited[i]) {
                visited[i] = true;
                dfs(i);
            }
        }
    }

    static Queue<Integer> q;
    static void bfs(int node) {
        q = new LinkedList<>();
        visited[node] = true;
        q.add(node);

        while (!q.isEmpty()) {
            int now = q.poll();
            System.out.print(now + " ");
            for (int i = 1; i <= N; i++) {
                if (graph[now][i] && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }

}
