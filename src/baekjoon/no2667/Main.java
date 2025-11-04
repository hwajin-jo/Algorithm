package baekjoon.no2667;

import java.io.*;
import java.util.*;

public class Main {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int N;
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    list.add(bfs(i, j));
                }
            }
        }

        Collections.sort(list);

        bw.write(list.size()+"\n");
        for (int cnt : list) {
            bw.write(cnt + "\n");
        }

        bw.flush();
        bw.close();
    }

    static int bfs (int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        int cnt = 0;
        while (!q.isEmpty()) {
            Point now = q.poll();
            cnt++;
            for (int d = 0; d < 4; d++) {
                int nx = now.x + dr[d];
                int ny = now.y + dc[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] == 0) continue;
                q.add(new Point(nx, ny));
                visited[nx][ny] = true;
            }
        }

        return cnt;
    }
}

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}