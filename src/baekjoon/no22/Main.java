package baekjoon.no22;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static int N, M, V;
    public static boolean[] visited = new boolean[1000];
    public static int[][] graph = new int[1000][1000];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 정점의 개수
        M = sc.nextInt(); // 간선의 개수
        V = sc.nextInt(); // 탐색시작 정점

        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        dfs(V);
    }

    public static void dfs(int start) {
        visited[start] = true;


    }
}
