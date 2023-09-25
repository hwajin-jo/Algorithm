package baekjoon.no15681;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Integer>[] tree;
    static boolean[] check;
    static int[] size;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 정점의 수
        int R = sc.nextInt(); // 루트 번호
        int Q = sc.nextInt(); // 쿼리의 수

        tree = new ArrayList[N + 1];
        check = new boolean[N + 1];
        size = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();

            tree[node1].add(node2);
            tree[node2].add(node1);
        }

        countSubTree(R);

        for (int i = 0; i < Q; i++) {
            int U = sc.nextInt();
            System.out.println(size[U]);
        }
    }

    static void countSubTree(int currentNode) {
        check[currentNode] = true;
        size[currentNode] = 1;
        for (int i = 0; i < tree[currentNode].size(); i++) {
            int child = tree[currentNode].get(i);
            if (!check[child]) {
                countSubTree(child);
                size[currentNode] += size[child];
            }
        }
    }
}
