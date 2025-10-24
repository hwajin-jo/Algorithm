package baekjoon.no1916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<ArrayList<Node>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(s).add(new Node(e, c));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int ans = solution(start, end, N);
        System.out.println(ans);
    }

    private static int solution(int start, int end, int N) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N + 1];

        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.city == end) {
                return cur.cost;
            }

            visited[cur.city] = true;

            for (Node next: graph.get(cur.city)) {
                if (!visited[next.city]) {
                    pq.add(new Node(next.city, cur.cost + next.cost));
                }
            }
        }


        return -1;
    }
}

class Node implements Comparable<Node> {
    int city;
    int cost;

    public Node(int city, int cost) {
        this.city = city;
        this.cost = cost;
    }
    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}
