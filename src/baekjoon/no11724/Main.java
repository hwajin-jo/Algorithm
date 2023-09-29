package baekjoon.no11724;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int N, M;
    static boolean[][] graph;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        graph = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];
        while (M-- > 0) {
            int src = sc.nextInt();
            int dst = sc.nextInt();

            graph[src][dst] = graph[dst][src] = true;
        }

        int result = 0;
        for (int i = 1; i <= N; i ++) {
            if (!visited[i]) {
                bfs(i);
                result++;
            }
        }

        System.out.println(result);
    }

    static Queue<Integer> q;
    static void bfs(int node) {
        q = new LinkedList<>();
        visited[node] = true;
        q.add(node);

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int i = 1; i <= N; i++) {
                if (graph[now][i] && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }

    }
}
