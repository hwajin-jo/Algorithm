package baekjoon.no11779;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int INF = 1000000001;
        int[] costs = new int[n + 1];
        List<Edge>[] graph = new List[n + 1];

        for (int i = 0; i <= n; i++) {
            costs[i] = INF;
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= m; i++) {
            int src = sc.nextInt();
            int dist = sc.nextInt();
            int cost = sc.nextInt();

            graph[src].add(new Edge(dist, cost));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        int[] path = new int[n + 1];

        int start = sc.nextInt();
        int end = sc.nextInt();

        costs[start] = 0;
        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            if (costs[now.dist] < now.cost) continue;

            for (Edge next : graph[now.dist]) {
                if (costs[now.dist] + next.cost < costs[next.dist]) {
                    costs[next.dist] = costs[now.dist] + next.cost;
                    pq.offer(new Edge(next.dist, costs[next.dist]));
                    path[next.dist] = now.dist;
                }
            }
        }

        Stack<Integer> stack = new Stack<>();
        int now = end;
        while (now != 0) {
            stack.push(now);
            now = path[now];
        }

        System.out.println(costs[end]);
        System.out.println(stack.size());
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}


class Edge {
    int dist, cost;

    public Edge (int dist, int cost) {
        this.dist = dist;
        this.cost = cost;
    }
}