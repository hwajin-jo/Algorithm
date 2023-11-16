package baekjoon.no1240;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Node>[] node;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        node = new ArrayList[N + 1];


        for (int i = 1; i <= N; i++) {
            node[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();
            int distance = sc.nextInt();

            node[node1].add(new Node(node2, distance));
            node[node2].add(new Node(node1, distance));
        }

        for (int i = 0; i < M; i++) {
            int current = sc.nextInt();
            int target = sc.nextInt();
            visited = new boolean[N + 1];
            visited[current] = true;
            solve(current, target, 0);
        }
    }

    static void solve(int current, int target, int distance) {
        // base case
        if (current == target) {
            System.out.println(distance);
            return;
        }
        // recursive case
        for (int i = 0; i < node[current].size(); i++) {
            Node data = node[current].get(i);
            if (!visited[data.edge]) {
                visited[data.edge] = true;
                solve(data.edge, target, distance + data.weight);
                visited[data.edge] = false;
            }
        }
    }
}

class Node {
    int edge;
    int weight;

    public Node(int e, int w) {
        edge = e;
        weight = w;
    }
}
