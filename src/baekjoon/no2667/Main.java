package baekjoon.no2667;

import java.util.*;

public class Main {

    static int N;
    static int[][] maps;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int count;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        maps = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String input = sc.next();
            for (int j = 0; j < N; j++) {
                maps[i][j] = input.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && maps[i][j] == 1) {
                    count = 1;
                    dfs(new Point(i, j));
                    list.add(count);
//                    bfs(new Point(i, j));
                }
            }
        }

        System.out.println(list.size());
        Collections.sort(list);
        for (Integer num : list) {
            System.out.println(num);
        }
    }

    static void dfs(Point now) {
        visited[now.r][now.c] = true;

        for (int i = 0; i < 4; i++) {
            int nr = now.r + dr[i];
            int nc = now.c + dc[i];

            if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
            if (visited[nr][nc]) continue;
            if (maps[nr][nc] == 1) {
                count++;
                dfs(new Point(nr, nc));
            }
        }
    }

    static void bfs(Point pt) {
        Queue<Point> q = new LinkedList<>();
        q.add(pt);
        visited[pt.r][pt.c] = true;

        int count = 1;
        while (!q.isEmpty()){
            Point now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];

                if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                if (visited[nr][nc]) continue;
                if (maps[nr][nc] == 1) {
                    visited[nr][nc] = true;
                    q.add(new Point(nr, nc));
                    count++;
                }
            }
        }
        list.add(count);
    }
}

class Point {
    int r, c;

    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}