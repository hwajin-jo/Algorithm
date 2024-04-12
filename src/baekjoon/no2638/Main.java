package baekjoon.no2638;

import java.util.*;

public class Main {

    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int time = 0;

        while (isContinue()) {

            // 외부 공기 검사
            bfs();

            // 외부 노출 치즈 녹이기
            melting();

            // 내외부 경계 초기화
            recover();

            time++;
        }


        System.out.println(time);
    }

    static void recover() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 2) {
                    map[i][j] = 0;
                }
            }
        }
    }
    static void bfs() {
        Queue<Point> q = new LinkedList<>();
        visited = new boolean[n][m];
        map[0][0] = 2;
        visited[0][0] = true;
        q.add(new Point(0, 0));

        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];

                if (isRange(nr, nc)) continue;
                if (visited[nr][nc]) continue;
                if (map[nr][nc] == 1) continue;

                visited[nr][nc] = true;
                map[nr][nc] = 2;
                q.add(new Point(nr, nc));
            }
        }

    }

    static void melting() {
        List<Point> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    int cnt = 0;
                    for (int d = 0; d < 4; d++) {
                        int nr = i + dr[d];
                        int nc = j + dc[d];

                        if (isRange(nr, nc)) continue;
                        if (map[nr][nc] == 2) {
                            cnt++;
                        }
                    }

                    if (cnt >= 2) {
                        list.add(new Point(i, j));
                    }
                }
            }
        }

        for (Point cheese : list) {
            map[cheese.r][cheese.c] = 0;
        }
    }

    static boolean isContinue() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    return true;
                }
            }
        }

        return false;
    }
    static boolean isRange(int r, int c) {
        return 0 > r || r >= n || 0 > c || c >= m;
    }
}

class Point {
    int r, c;

    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
