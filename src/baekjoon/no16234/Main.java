package baekjoon.no16234;

import java.util.*;

public class Main {

    static int[][] map;
    static boolean[][] visited;

    static int n, l, r;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static List<Point> sumList;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        l = sc.nextInt();
        r = sc.nextInt();

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int days = 0;

        while (true) {
            boolean flag = false;
            visited = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        int sum = bfs(i, j);
                        if (sumList.size() > 1) {
                            chagePopulation(sum);
                            flag = true;
                        }
                    }
                }
            }

            if (!flag) break;
            days++;
        }

        System.out.println(days);
    }

    private static void chagePopulation(int sum) {
        int population = sum / sumList.size();
        for (Point country : sumList) {
            map[country.r][country.c] = population;
        }
    }

    static int bfs(int row, int col) {
        Queue<Point> q = new LinkedList<>();
        sumList = new ArrayList<>();

        q.add(new Point(row, col));
        visited[row][col] = true;
        sumList.add(new Point(row, col));

        int sum = map[row][col];
        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];

                if (nr < 0 || nc < 0 || nr >= n || nc >= n) continue;
                if (visited[nr][nc]) continue;

                int diff = Math.abs(map[now.r][now.c] - map[nr][nc]);

                if (l <= diff && diff <= r) {
                    visited[nr][nc] = true;
                    sum += map[nr][nc];
                    q.add(new Point(nr, nc));
                    sumList.add(new Point(nr, nc));
                }
            }
        }

        return sum;
     }
}

class Point {
    int r, c;

    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
