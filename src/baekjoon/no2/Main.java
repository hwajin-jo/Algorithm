package baekjoon.no2;

import java.util.Scanner;

// 11724 연결 요소 갯수(DFS)
public class Main {

    public static int n,m;

    public static int[][] graph;
    public static boolean[] visit;

    public static void dfs(int start) {

        visit[start] = true;

        for (int i = 1; i < n+1; i++) {
            if (graph[start][i] == 1 && !visit[i]) {
                dfs(i);
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        graph = new int[n+1][n+1];
        visit = new boolean[n+1];

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        int cnt = 0;
        // 방문 배열을 돌면서 방문하지 않은 정점이 있다면 탐색하고 연결요소 +1 증가
        for (int i = 1; i <= n; i++) {
            if (!visit[i]) {
                dfs(i);
                cnt+=1;
            }
        }
        System.out.println(cnt);
    }

}
