package baekjoon.no7562;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[][] visited;
    static int N;
    static int[] dx = {1, 2, 1, 2, -1, -2, -1, -2};
    static int[] dy = {2, 1, -2, -1, 2, 1, -2, -1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            N = sc.nextInt();
            visited = new int[N][N];
            int start_x = sc.nextInt();
            int start_y = sc.nextInt();
            int end_x = sc.nextInt();
            int end_y = sc.nextInt();

            bfs(start_x, start_y, end_x, end_y);

            System.out.println(visited[end_x][end_y] - 1);
        }
    }

    static void bfs(int startX, int startY, int endX, int endY) {
        Queue<Point> q = new LinkedList<>();
        visited[startX][startY] = 1;
        q.add(new Point(startX, startY));

        while (!q.isEmpty()) {
            Point now = q.poll();

            if (now.x == endX && now.y == endY) {
                break;
            }
            for (int i = 0; i < 8; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visited[nx][ny] == 0) {
                    visited[nx][ny] = visited[now.x][now.y] + 1;
                    q.add(new Point(nx, ny));
                }
            }
        }


    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
