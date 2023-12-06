package baekjoon.no1707;

import java.util.*;

public class Main {

    static List<Integer>[] graph;
    static int[] color;
    static final int RED = 1;
    static final int BLUE = 2;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int v = sc.nextInt();
            int e = sc.nextInt();
            graph = new List[v + 1];
            color = new int[v + 1];
            visited = new boolean[v + 1];
            for (int i = 1; i <= v; i++) {
                graph[i] = new ArrayList();
            }

            for (int i = 0; i < e; i++) {
                int node1 = sc.nextInt();
                int node2 = sc.nextInt();

                graph[node1].add(node2);
                graph[node2].add(node1);
            }

            for (int i = 1; i <= v; i++) {
                coloring(i, 0);
            }

            if (isBinary()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    static boolean isBinary() {
        for (int i = 1; i < graph.length; i++) {
            for (int next : graph[i]) {
                if (color[next] == color[i]) return false;
            }
        }

        return true;
    }

    static void coloring(int node, int depth) {
        if (color[node] != 0) return;

        if (depth % 2 == 0)
            color[node] = RED;
        else
            color[node] = BLUE;

        for (int next : graph[node]) {
            coloring(next, depth + 1);
        }
    }
}
