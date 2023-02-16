package baekjoon.no7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 11725 - 트리의 부모 찾
public class Main {

    public static void bfs(int start, ArrayList<ArrayList<Integer>> graph, int[] parents, int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        parents[start] = 1;

        while (!queue.isEmpty()) {
            int parent = queue.poll();

            for (int item : graph.get(parent)) {
                if (parents[item] == 0) {
                    parents[item] = parent;
                    queue.offer(item);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] parents = new int[n+1];

        ArrayList< ArrayList<Integer> > graph = new ArrayList< ArrayList<Integer> >();
        // 초기화
        for (int i = 0; i <= n+1; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 1; i < n; i++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            graph.get(n1).add(n2);
            graph.get(n2).add(n1);
        }

        bfs(1, graph, parents, n);

        for (int i = 2; i <= n; i++) {
            System.out.println(parents[i]);
        }

    }
}
