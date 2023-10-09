package baekjoon.no5427;


import java.util.*;

public class Main {

    static int W, H;
    static char[][] building;
    static int[][] times;
    static int[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            W = sc.nextInt();
            H = sc.nextInt();

            building = new char[H][W];
            visited = new int[H][W];
            times = new int[H][W];
            Queue<Point> personQ = new LinkedList<>();
            Queue<Point> fireQ = new LinkedList<>();

            for (int i = 0; i < H; i++) {
                String input = sc.next();
                for (int j = 0; j < W; j++) {
                    building[i][j] = input.charAt(j);
                    if (building[i][j] == '@') {
                        personQ.add(new Point(i, j));
                        visited[i][j] = 1;
                    } else if (building[i][j] == '*') {
                        fireQ.add(new Point(i, j));
                        times[i][j] = 1;
                    } else if (building[i][j] == '#') {
                        times[i][j] = visited[i][j] = -1;
                    }
                }
            }

            int result = bfs(fireQ, personQ);
            if (result == -1) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(result);
            }
        }
    }

    public static int bfs(Queue<Point> fireQ, Queue<Point> personQ) {

        // 불이 번지는 시간을 depth에 따라 기록
        while (!fireQ.isEmpty()) {
            Point now = fireQ.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= H || ny >= W) continue;
                if (times[nx][ny] == 0 && building[nx][ny] != '#') {
                    times[nx][ny] = times[now.x][now.y] + 1;
                    fireQ.add(new Point(nx, ny));
                }
            }
        }

        // 불이 번지는 depth보다 낮거나 같다면 상근이 이동
        while (!personQ.isEmpty()) {
            Point now = personQ.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= H || ny >= W) return visited[now.x][now.y];
                if (visited[nx][ny] != 0) continue;
                if (visited[now.x][now.y] + 1 < times[nx][ny] || times[nx][ny] == 0) {
                    visited[nx][ny] = visited[now.x][now.y] + 1;
                    personQ.add(new Point(nx, ny));
                }
            }
        }

        return -1;
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

