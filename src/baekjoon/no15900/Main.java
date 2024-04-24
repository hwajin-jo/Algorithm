package baekjoon.no15900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static List<Integer>[] tree;
    static boolean[] visited;
    static int[] depth;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        tree = new List[n + 1];
        visited = new boolean[n + 1];
        depth = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            tree[node1].add(node2);
            tree[node2].add(node1);
        }

        ans = 0;
        visited[1] = true;
        solve(1, 0);

        if (ans % 2 == 0) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
    }

    static void solve(int cur, int cnt) {
        depth[cur] = cnt;

        if (tree[cur].size() == 1) {
            ans += depth[cur];
        }

        for (int next : tree[cur]) {
            if (!visited[next]) {
                visited[next] = true;
                solve(next, cnt + 1);
                visited[next] = false;
            }
        }
    }
}
