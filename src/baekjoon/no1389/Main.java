package baekjoon.no1389;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int ans = 0;
    static List<Integer>[] graph;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        graph = new List[n + 1];
        arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();

            graph[node1].add(node2);
            graph[node2].add(node1);
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            Arrays.fill(arr, Integer.MAX_VALUE);
            arr[i] = 0;
            solve(i, 0);
            int sum = 0;

            for (int j = 1; j <= n; j++) {
                sum += arr[j];
            }

            if (min > sum) {
                min = sum;
                ans = i;
            }
        }

        System.out.println(ans);
    }

    static void solve(int node, int depth) {
        for (Integer next : graph[node]) {
            if (arr[next] > depth) {
                arr[next] = depth;
                solve(next, depth + 1);
            }
        }
    }
}
