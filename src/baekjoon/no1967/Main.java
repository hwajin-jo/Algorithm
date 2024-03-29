package baekjoon.no1967;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int n;
    static List<Node>[] tree;
    static int max = 0;
    static int findNode = 0;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        tree = new List[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();
            int cost = sc.nextInt();

            tree[node1].add(new Node(node2, cost));
            tree[node2].add(new Node(node1, cost));
        }

        dfs(1, 0);
        max = 0;
        Arrays.fill(visited, false);
        dfs(findNode, 0);

        System.out.println(max);
    }

    static void dfs(int now, int sum) {
        visited[now] = true;
        if (sum > max) {
            max = sum;
            findNode = now;
        }

        for (Node node : tree[now]) {
            if (!visited[node.data]) {
                dfs(node.data, sum + node.cost);
            }
        }
    }
}

class Node {
    int data;
    int cost;

    public Node (int data, int cost) {
        this.data = data;
        this.cost = cost;
    }
}
