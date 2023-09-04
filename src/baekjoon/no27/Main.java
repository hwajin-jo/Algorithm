package baekjoon.no27;

import java.io.*;
import java.util.*;

// 17086 - 아기상어2
public class Main {

    static int[] dx = {-1, 1, 0, 0, 1, 1, -1, -1};
    static int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};
    public static int N, M;
    public static int[][] graph;
    public static int[][] distance;

    public static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        distance = new int[N][M];

        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int input= Integer.parseInt(st.nextToken());
//                graph[i][j] = input;
                distance[i][j] = Integer.MAX_VALUE;

                if (input == 1) {
                    q.offer(new Node(i, j));
                    distance[i][j] = 0;
                }
            }
        }

        int answer = 0;

        while (!q.isEmpty()) {
            Node now = q.poll();

            for (int i = 0; i < 8; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx >= 0 && ny >=0 && nx < N && ny < M) {
                    if (distance[nx][ny] > distance[now.x][now.y] + 1) {
                        distance[nx][ny] = distance[now.x][now.y] + 1;
                        q.offer(new Node(nx, ny));
                        answer = Math.max(answer, distance[nx][ny]);
                    }
                }
            }
        }


        System.out.println(answer);
    }

    public static class Node {
        private int x;
        private int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
