package baekjoon.no1916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        final int INF = 1000000000;

        int[][] graph = new int[n + 1][n + 1];
        int[] cost = new int[n + 1];
        boolean[] visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            cost[i] = INF;

            for (int j = 0; j <= n; j++) {
                graph[i][j] = INF;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

           if (graph[a][b] > w) {
               graph[a][b] = w;
           }
        }

        st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        cost[start] = 0;

        for (int i = 1; i <= n; i++) {
            int min = INF;
            int minIndex = -1;
            for (int j = 1; j <= n; j++) {
                if (min > cost[j] && !visited[j]) {
                    min = cost[j];
                    minIndex = j;
                }
            }

            if (minIndex == -1) break;
            visited[minIndex] = true;

            for (int j = 1; j <= n; j++) {
                if (cost[j] > cost[minIndex] + graph[minIndex][j]) {
                    cost[j] = cost[minIndex] + graph[minIndex][j];
                }
            }
        }

        System.out.println(cost[end]);
    }
}
