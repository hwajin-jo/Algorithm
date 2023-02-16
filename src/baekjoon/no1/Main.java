package baekjoon.no1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
    private int x;
    private int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}

public class Main {

    public static int n, m;
    // 상 하 좌 우
    public static int[] dx = { -1, 1, 0, 0 };
    public static int[] dy = { 0, 0, -1, 1 };

    public static int bfs(int[][] graph) {
        Queue<Node> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 익은 토마토가 있는 모든 위치를 큐에 담는다.
                if (graph[i][j] == 1) {
                    q.offer(new Node(i, j));
                }
            }
        }

        while (!q.isEmpty()) {
            Node node = q.poll();

            int x = node.getX();
            int y = node.getY();

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 영역 밖이면 무시
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                // 익은 토마토 or 비어있는 곳이라면 무시
                if (graph[nx][ny] != 0) continue;
                // 익지 않은 토마토가 존재한다면 계산
                if (graph[nx][ny] == 0) {
                    graph[nx][ny] = graph[x][y] + 1;
                    q.offer(new Node(nx, ny));
                }
            }
        }

        int max = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 0) {
                    return -1;
                }
                max = Math.max(max, graph[i][j]);
            }
        }

        if (max == 1) return 0;
        else return max-1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();
        int[][] graph = new int[n][m];


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        System.out.println(bfs(graph));
    }
}
