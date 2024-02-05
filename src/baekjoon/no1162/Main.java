package baekjoon.no1162;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final long INF = Long.MAX_VALUE / 2;

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        List<Edge>[] graph = new List[n + 1];
        long[][] cost = new long[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            for (int j = 0; j <= k; j++) {
                cost[i][j] = INF;
            }
        }

        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int d = sc.nextInt();
            int c = sc.nextInt();
            graph[s].add(new Edge(d, c, 0));
            graph[d].add(new Edge(s, c, 0));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> Long.compare(o1.cost, o2.cost));

        pq.offer(new Edge(1, 0 , 0));
        cost[1][0] = 0;

        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            if (cost[now.dist][now.cnt] < now.cost) continue;
            for (Edge next : graph[now.dist]) {
                // 도로 포장을 하지 않고 그냥 탐색
                if (cost[next.dist][now.cnt] > cost[now.dist][now.cnt] + next.cost) {
                    cost[next.dist][now.cnt] = cost[now.dist][now.cnt] + next.cost;
                    pq.offer(new Edge(next.dist, cost[next.dist][now.cnt], now.cnt));
                }

                // 도로 포장을 하는 경우
                if (now.cnt + 1 <= k && cost[next.dist][now.cnt + 1] > cost[now.dist][now.cnt]) {
                    cost[next.dist][now.cnt + 1] = cost[now.dist][now.cnt];
                    pq.offer(new Edge(next.dist, cost[next.dist][now.cnt + 1], now.cnt + 1));
                }
            }
        }

        long ans = INF;
        for (int i = 0; i <= k; i++) {
            ans = Math.min(ans, cost[n][i]);
        }

        System.out.println(ans);
    }
}

class Edge {
    int dist;
    long cost;
    int cnt;

    public Edge(int dist, long cost, int cnt) {
        this.dist = dist;
        this.cost = cost;
        this.cnt = cnt;
    }
}
