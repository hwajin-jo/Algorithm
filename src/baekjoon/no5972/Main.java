package baekjoon.no5972;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Node>[] graph = new List[n + 1];
        int[] arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dst = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[src].add(new Node(dst, weight));
            graph[dst].add(new Node(src, weight));
        }


        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.cost > o2.cost) return 1;
            else if (o1.cost == o2.cost) return 0;
            else return -1;
        });
        pq.offer(new Node(1, 0));
        arr[1] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if(arr[now.data] < now.cost) continue;

            for (Node next : graph[now.data]) {
                int data = next.data;
                int distance = next.cost;

                int cost = arr[now.data] + distance;

                if (arr[data] > cost) {
                    arr[data] = cost;
                    pq.offer(new Node(data, cost));
                }
            }
        }

        System.out.println(arr[n]);
    }
}

class Node {
    int data;
    int cost;

    public Node(int data, int cost) {
        this.data = data;
        this.cost = cost;
    }
}