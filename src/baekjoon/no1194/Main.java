package baekjoon.no1194;

import java.util.*;

public class Main {

    static final int WALL = 1;
    static final int NONE = 2;
    static final int KEY = 3;
    static final int DOOR = 4;
    static final int EXIT = 5;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        char[][] board = new char[N][M];
        int[][][] visited = new int[N][M][1 << 6];
        Queue<Point> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            String input = sc.next();
            for (int j = 0; j < M; j++) {
                board[i][j] = input.charAt(j);
                if (board[i][j] == '0') {
                    q.add(new Point(i, j, 0));
                    visited[i][j][0] = 1;
                }
            }
        }
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                int next = board[nx][ny];
                switch (getType(next)) {
                    case WALL:
                        break;
                    case NONE: {
                        if (visited[nx][ny][now.keys] == 0) {
                            visited[nx][ny][now.keys] = visited[now.x][now.y][now.keys] + 1;
                            q.add(new Point(nx, ny, now.keys));
                        }
                    }
                    break;
                    case KEY: {
                        int nextKey = now.keys | (1 << (next - 'a'));

                        if (visited[nx][ny][nextKey] == 0) {
                            visited[nx][ny][nextKey] = visited[now.x][now.y][now.keys] + 1;
                            q.add(new Point(nx, ny, nextKey));
                        }
                    }
                    break;
                    case DOOR: {
                        if ((now.keys & (1 << (next - 'A'))) == 0) continue;
                        if (visited[nx][ny][now.keys] == 0) {
                            visited[nx][ny][now.keys] = visited[now.x][now.y][now.keys] + 1;
                            q.add(new Point(nx, ny, now.keys));
                        }
                    }
                    break;
                    case EXIT: {
                        System.out.println(visited[now.x][now.y][now.keys]);
                        return;
                    }
                }
            }
        }

        System.out.println(-1);
    }

    static int getType(int next) {
        if (next == '#') return WALL;
        else if (next == '.' || next == '0') return NONE;
        else if (next >= 'a' && next <= 'z') return KEY;
        else if (next >= 'A' && next <= 'Z') return DOOR;
        else if (next == '1') return EXIT;
        else return -1;
    }
}

class Point {
    int x, y;
    int keys;

    public Point(int x, int y, int k) {
        this.x = x;
        this.y = y;
        this.keys = k;
    }
}


