package baekjoon.no2623;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        List<Integer>[] list = new List[n + 1];

        Queue<Integer> q = new LinkedList<>();
        int[] indegree = new int[n + 1];
        int[] check = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int num = sc.nextInt();

            int src = -1;
            for (int j = 0; j < num; j++) {
                int dest= sc.nextInt();

                if (j == 0) {
                    src = dest;
                } else {
                    list[src].add(dest);
                    indegree[dest]++;
                    src = dest;
                }
            }
        }

        for (int i = 1; i < indegree.length; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }


        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            int now = q.poll();
            check[now] = 1;
            ans.add(now);
            if (ans.size() > n) {
                System.out.println(0);
                return;
            }

            for (int next : list[now]) {
                if (check[next] == 1) continue;
                indegree[next]--;
                if (indegree[next] == 0)
                    q.add(next);
            }
        }

        for (int i = 1; i <= n; i++) {
            if (check[i] == 0) {
                System.out.println(0);
                return;
            }
        }

        for (Integer data : ans) {
            System.out.println(data);
        }
    }
}
