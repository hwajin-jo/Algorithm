package baekjoon.no16234;

import java.util.*;

public class Main {

    static int[][] map;
    static boolean[][] visited;
    static int n, l, r;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static Queue<Point> q;

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
        q = new LinkedList<>();
        while(true) {
            Set<Point> pointSet = getStart();
            if (pointSet.size() < 1) break;
            days++;
            visited = new boolean[n][n];
            List<Point> sumList = new ArrayList<>();

            int sum = 0;
            for (Point data : pointSet) {
                sum += map[data.r][data.c];
                sumList.add(new Point(data.r, data.c));
            }

            q.addAll(pointSet);
            while (!q.isEmpty()) {
                Point now = q.poll();
                visited[now.r][now.c] = true;
                for (int d = 0; d < 4; d++) {
                    int nr = now.r + dr[d];
                    int nc = now.c + dc[d];

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

            if (sumList.size() > 1) {
                int data = sum / sumList.size();
                for (Point now : sumList) {
                    map[now.r][now.c] = data;
                }
            }
        }

        System.out.println(days);
    }

    static Set<Point> getStart() {
        Set<Point> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int d = 0; d < 4; d++) {
                    int nr = i + dr[d];
                    int nc = j + dc[d];

                    if (nr < 0 || nc < 0 || nr >= n || nc >= n) continue;
                    int diff = Math.abs(map[i][j] - map[nr][nc]);
                    if (l <= diff && diff <= r) {
                        set.add(new Point(i, j));
                    }
                }
            }
        }

        return set;
    }
}

class Point {
    int r, c;

    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
