package baekjoon.no17142;

import java.util.*;

public class Main {

    static int n, m;
    static int[][] labs;

    static List<Point> virusList;
    static Point[] temp;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        labs = new int[n][n];

        virusList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                labs[i][j] = sc.nextInt();
                if (labs[i][j] == 2) {
                    virusList.add(new Point(i, j , 0));
                }
            }
        }


        ans = Integer.MAX_VALUE;
        temp = new Point[m];
        solve(0, 0);

        if (ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }

    static void solve(int depth, int start) {
        if (depth == m) {
            bfs();
            return;
        }

        for (int i = start; i < virusList.size(); i++) {
            temp[depth] = virusList.get(i);
            solve(depth + 1, i + 1);
        }

    }

    static void bfs() {
        Queue<Point> q = new LinkedList<>(Arrays.asList(temp));
        boolean[][] visited = new boolean[n][n];
        for (Point virus : temp) {
            visited[virus.r][virus.c] = true;
        }

        int[][] copy = copyOfLabs();

        int max = 0;
        while (!q.isEmpty()) {
            Point now = q.poll();
            if (copy[now.r][now.c] != -2)
                max = Math.max(max, now.cnt);
            for (int d = 0; d < 4; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];
                if (nr < 0 || nc < 0 || nr >= n || nc >= n) continue;
                if (visited[nr][nc]) continue;
                if (copy[nr][nc] == -1) continue;

                visited[nr][nc] = true;
                if (copy[nr][nc] != -2)
                    copy[nr][nc] = now.cnt + 1;
                q.add(new Point(nr, nc, now.cnt + 1));
            }
        }


        if (!isValid(copy)) {
            ans = Math.min(ans, max);
        }
    }

    static boolean isValid(int[][] copy) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (copy[i][j] == 0)
                    return true;
            }
        }

        return false;
    }

    static int[][] copyOfLabs() {
        int[][] copy = new int[n][n];
        // 벽인 경우
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (labs[i][j] == 1) {
                    copy[i][j] = -1;
                } else {
                    copy[i][j] = labs[i][j];
                }
            }
        }

        // 비활성 바이러스인 경우
        for (Point p : virusList) {
            for (Point point : temp) {
                if (p.r == point.r && p.c == point.c) continue;
                copy[p.r][p.c] = -2;
            }
        }

        return copy;
    }
}

class Point {
    int r, c;
    int cnt;

    public Point (int r, int c, int cnt) {
        this.r = r;
        this.c = c;
        this.cnt = cnt;
    }
}