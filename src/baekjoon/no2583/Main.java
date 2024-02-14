package baekjoon.no2583;

import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();
        int K = sc.nextInt();

        map = new int[N][M];

        while (K-- > 0) {
            int startRow = sc.nextInt();
            int startCol = sc.nextInt();
            int endRow = sc.nextInt();
            int endCol = sc.nextInt();

            for (int i = startRow; i < endRow; i++) {
                for (int j = startCol; j < endCol; j++) {
                    map[i][j] = -1;
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    result.add(bfs(i, j));
                }
            }
        }

        Collections.sort(result);
        System.out.println(result.size());

        for (Integer area : result) {
            System.out.print(area + " ");
        }
        System.out.println();
    }

    static int bfs(int r, int c) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(r, c));

        int area = 1;
        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];

                if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                if (map[nr][nc] == -1) continue;
                if (map[nr][nc] == 0) {
                    map[nr][nc] = ++area;
                    q.add(new Point(nr, nc));
                }
            }
        }

        return area;
    }
}

class Point {
    int r, c;

    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
