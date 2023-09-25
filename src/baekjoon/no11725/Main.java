package baekjoon.no11725;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Integer>[] tree;
    static int[] parents;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        parents = new int[N + 1];
        visited = new boolean[N + 1];

        tree = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();

            tree[node1].add(node2);
            tree[node2].add(node1);
        }

        find(1);

        for (int i = 2; i <= N; i++) {
            System.out.println(parents[i]);
        }
    }

    public static void find(int nodeNumber) {
        visited[nodeNumber] = true;
        for (int i = 0; i < tree[nodeNumber].size(); i++) {
            int child = tree[nodeNumber].get(i);
            if (!visited[child]) {
                parents[child] = nodeNumber;
                find(child);
            }
        }
    }
}
