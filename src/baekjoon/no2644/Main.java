package baekjoon.no2644;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList[] graph;
    static boolean[] visited;
    static int ans = -1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        int origin = sc.nextInt();
        int target = sc.nextInt();

        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();

            graph[node1].add(node2);
            graph[node2].add(node1);
        }

        solve(origin, target, 0);

        System.out.println(-1);
    }

    static void solve(int origin, int target, int count) {
        if (origin == target) {
            System.out.println(count);
            System.exit(0);
        }

        for (int i = 0; i < graph[origin].size(); i++) {
            int next = (int) graph[origin].get(i);

            if (!visited[next]) {
                visited[next] = true;
                solve(next, target, count + 1);
                visited[next] = false;
            }
        }
    }
}
