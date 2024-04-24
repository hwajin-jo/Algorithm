package baekjoon.no17141;

import java.util.*;

public class Main {
    static int n, m;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] arr;
    static List<Point> virus;
    static int[] temp;

    static int ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n][n];
        temp = new int[m];
        virus = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();

                if (arr[i][j] == 2) {
                    virus.add(new Point(i, j));
                }
            }
        }

        ans = Integer.MAX_VALUE;
        selectVirus(0, 0);

        if (ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }

    static void selectVirus(int depth, int start) {
        if (depth == m) {
            bfs();
            return;
        }

        for (int i = start; i < virus.size(); i++) {
            temp[depth] = i;
            selectVirus(depth + 1, i + 1);
        }
    }

    static void bfs() {
        int[][] labs = copyOfArr();
        boolean[][] visited = new boolean[n][n];
        Queue<Point> q = new LinkedList<>();
        for (int i = 0; i < temp.length; i++) {
            Point bug = virus.get(temp[i]);
            q.add(bug);
            labs[bug.r][bug.c] = 0;
            visited[bug.r][bug.c] = true;
        }

        int max = -1;
        while (!q.isEmpty()) {
            Point now = q.poll();
            max = Math.max(max, labs[now.r][now.c]);
            for (int d = 0; d < 4; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];

                if (nr < 0 || nc < 0 || nr >= n || nc >= n) continue;
                if (visited[nr][nc]) continue;
                if (labs[nr][nc] == 1) continue;
                visited[nr][nc] = true;
                labs[nr][nc] = labs[now.r][now.c] + 1;
                q.add(new Point(nr, nc));
            }
        }

        if (isValid(labs, visited)) {
            ans = Math.min(ans, max);
        }
    }

    static boolean isValid(int[][] labs, boolean[][] visited) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && labs[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    static int[][] copyOfArr() {
        int[][] labs = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                labs[i][j] = arr[i][j];
            }
        }

        return labs;
    }
}

class Point {
    int r, c;

    public Point (int r, int c) {
        this.r = r;
        this.c = c;
    }
}
