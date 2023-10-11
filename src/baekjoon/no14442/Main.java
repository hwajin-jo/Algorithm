package baekjoon.no14442;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] board = new int[N + 1][M + 1];
        int[][][] visited = new int[K + 1][N + 1][M + 1];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 1; i <= N; i++) {
            String input = br.readLine();
            for (int j = 1; j <= M; j++) {
                board[i][j] = input.charAt(j - 1) - '0';
            }
        }

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(1, 1, 0));
        visited[0][1][1] = 1;

        while (!q.isEmpty()) {
            Point now = q.poll();

            if (now.x == N && now.y == M) {
                System.out.println(visited[now.destroy][N][M]);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx <= 0 || ny <= 0 || nx > N || ny > M) continue;
                if (visited[now.destroy][nx][ny] == 0) {
                    if (board[nx][ny] == 0) {
                        visited[now.destroy][nx][ny] = visited[now.destroy][now.x][now.y] + 1;
                        q.add(new Point(nx, ny, now.destroy));
                    } else if (board[nx][ny] == 1 && now.destroy < K
                            && visited[now.destroy+1][nx][ny] == 0) {
                        visited[now.destroy + 1][nx][ny] = visited[now.destroy][now.x][now.y] + 1;
                        q.add(new Point(nx, ny, now.destroy + 1));
                    }
                }
            }
        }
        System.out.println(-1);
    }
}

class Point {
    int x, y;
    int destroy;

    public Point(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.destroy = d;
    }
}