package baekjoon.no4803;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Integer>[] tree;
    static boolean[] visited;
    static boolean flag;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int test_case = 1;
        while (true) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            if (n == 0 && m == 0) break;

            init(n);

            for (int i = 0; i < m; i++) {
                int node1 = sc.nextInt();
                int node2 = sc.nextInt();

                tree[node1].add(node2);
                tree[node2].add(node1);
            }

            int res = 0;
            for (int i = 1; i <= n; i++) {
                flag = true;
                if (!visited[i] && isTree(i)) {
                    res++;
                }
            }

            if (res == 0) {
                System.out.println("Case " + test_case + ": No trees.");
            } else if (res == 1) {
                System.out.println("Case " + test_case + ": There is one tree.");
            } else if (res > 1) {
                System.out.println("Case " + test_case + ": A forest of " + res + " trees.");
            }

            test_case++;
        }
    }

    private static boolean isTree(int node) {
        visited[node] = true;

        for (int i = 0; i < tree[node].size(); i++) {
            int next = tree[node].get(i);

            if (!visited[next]) {
                tree[next].remove((Integer) node);
                isTree(next);
            } else {
                flag= false;
            }
        }

        return flag;
    }

    private static void init(int n) {
        tree = new List[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
    }
}
