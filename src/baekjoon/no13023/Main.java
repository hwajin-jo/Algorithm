package baekjoon.no13023;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Integer>[] graph;
    static boolean[] visited;
    static boolean flag = false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        graph = new List[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList();
        }

        for (int i = 0; i < m; i++) {
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();

            graph[node1].add(node2);
            graph[node2].add(node1);
        }

        for (int i = 0; i < n; i++) {
            visited = new boolean[n];
            visited[i] = true;
            dfs(i, 1);

            if (flag) break;
        }

        if (flag) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    static void dfs(int node, int depth) {
        if (depth == 5) {
            flag = true;
            return;
        }

        for (Integer next : graph[node]) {
            if (!visited[next]) {
                visited[next] = true;
                dfs(next, depth + 1);
                visited[next] = false;
            }
        }
    }
}
