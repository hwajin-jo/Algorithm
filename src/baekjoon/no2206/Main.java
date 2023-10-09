package baekjoon.no2206;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[][] maps;
    static int[][][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        maps = new int[N + 1][M + 1];
        visited = new int[N + 1][M + 1][2];
        for (int i = 1; i <= N; i++) {
            String input = sc.next();
            for (int j = 1; j <= M; j++) {
                maps[i][j] = input.charAt(j - 1) - '0';
            }
        }

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(1, 1, 0));
        visited[1][1][0] = 1;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            Point now = q.poll();

            if (now.x == N && now.y == M) {
                System.out.println(visited[now.x][now.y][now.isBroken]);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx <= 0 || ny <= 0 || nx > N || ny > M) continue;
                if (visited[nx][ny][now.isBroken] == 0) {
                    if (maps[nx][ny] == 0) {
                        visited[nx][ny][now.isBroken] = visited[now.x][now.y][now.isBroken] + 1;
                        q.add(new Point(nx, ny, now.isBroken));
                    } else if (maps[nx][ny] == 1 && now.isBroken == 0) {
                        visited[nx][ny][1] = visited[now.x][now.y][0] + 1;
                        q.add(new Point(nx, ny,  1));
                    }
                }
            }
        }

        System.out.println(-1);
    }
}

class Point {
    int x, y, isBroken;

    public Point(int x, int y, int isBroken) {
        this.x = x;
        this.y = y;
        this.isBroken = isBroken;
    }
}

