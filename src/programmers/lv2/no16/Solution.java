package programmers.lv2.no16;
import java.util.*;
class Solution {
    static List[] graph;
    static boolean[] visited;
    static int[] times;
    public int solution(int N, int[][] road, int K) {
        int answer = 1;

        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        times = new int[N + 1];
        Arrays.fill(times, Integer.MAX_VALUE);
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<Node>();
        }

        for (int i = 0; i < road.length; i++) {
            int node1 = road[i][0];
            int node2 = road[i][1];
            int weight = road[i][2];
            graph[node1].add(new Node(node2, weight));
            graph[node2].add(new Node(node1, weight));
        }

        dfs(1, 0);

        for (int i = 2; i < times.length; i++) {
            if (times[i] <= K) answer++;
        }
        return answer;
    }

    static void dfs(int idx, int time) {
        for (int i = 0; i < graph[idx].size(); i++) {
            Node node = (Node) graph[idx].get(i);

            if (!visited[node.edge] & times[node.edge] >= time + node.weight) {
                visited[node.edge] = true;
                time += node.weight;
                times[node.edge] = time;
                dfs(node.edge, time);
                time -= node.weight;
                visited[node.edge] = false;
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