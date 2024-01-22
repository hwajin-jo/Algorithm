package baekjoon.no1916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Node>[] graph;
    static boolean[] visited;
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, w));
        }

        st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        solve(start, end, 0);
        System.out.println(ans);
    }

    static void solve(int start, int end, int sum) {
        if (start == end) {
            ans = Math.min(ans, sum);
            return;
        }

        for (int i = 0; i < graph[start].size(); i++) {
            if (!visited[start]) {
                visited[start] = true;
                Node node = graph[start].get(i);
                solve(node.v, end, sum + node.w);
                visited[start] = false;
            }
        }
    }
}

class Node {
    int v, w;

    public Node(int v, int w) {
        this.v = v;
        this.w = w;
    }
}