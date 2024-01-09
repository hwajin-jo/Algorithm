package baekjoon.no2252;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<Integer>[] list = new List[n + 1];
        int[] indgree = new int[n + 1];
        int[] check = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int src = sc.nextInt();
            int dist = sc.nextInt();
            list[src].add(dist);
            indgree[dist]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (indgree[i] == 0) q.add(i);
        }

        while (!q.isEmpty()) {
            int now = q.poll();
            check[now] = 1;
            System.out.print(now + " ");

            for (int next : list[now]) {
                if (check[next] == 1) continue;
                indgree[next]--;
                if (indgree[next] == 0) q.add(next);
            }
        }
    }
}
