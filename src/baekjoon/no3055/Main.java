package baekjoon.no3055;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        char[][] map = new char[n][m];

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        Queue<Point> water = new LinkedList<>();
        Queue<Go> q = new LinkedList<>();

        int destR = -1;
        int destC = -1;
        for (int i = 0; i < n; i++) {
            map[i] = sc.next().toCharArray();
            for (int j = 0; j < map[i].length; j++) {

                if (map[i][j] == 'S') {
                    q.add(new Go(i, j, 0));
                }

                if (map[i][j] == '*') {
                    water.add(new Point(i, j));
                }

                if (map[i][j] == 'D') {
                    destR = i;
                    destC = j;
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            // 물 퍼트림
            int len = water.size();

            for (int i = 0; i < len; i++) {
                Point now = water.poll();

                for (int d = 0; d < 4; d++) {
                    int nr = now.r + dr[d];
                    int nc = now.c + dc[d];

                    if (nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
                    if (map[nr][nc] == 'X') continue;
                    if (map[nr][nc] == 'D') continue;
                    if (map[nr][nc] == '*') continue;
                    map[nr][nc] = '*';
                    water.add(new Point(nr, nc));
                }
            }

            // 고슴도치 이동
            len = q.size();
            for (int i = 0; i < len; i++) {
                Go now = q.poll();

                if (now.r == destR && now.c == destC) {
                    ans = Math.min(ans, now.cnt);
                }

                for (int d = 0; d < 4; d++) {
                    int nr = now.r + dr[d];
                    int nc = now.c + dc[d];

                    if (nr < 0 || nc < 0 || nr >= n || nc >= m) continue;

                    if (map[nr][nc] == 'X') continue;
                    if (map[nr][nc] == 'S') continue;
                    if (map[nr][nc] == '*') continue;
                    map[nr][nc] = 'S';
                    q.add(new Go(nr, nc, now.cnt + 1));
                }
            }
        }

        if (ans == Integer.MAX_VALUE) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(ans);
        }
    }
}

class Go {
    int r, c;
    int cnt;

    public Go(int r, int c, int cnt) {
        this.r = r;
        this.c = c;
        this.cnt = cnt;
    }
}

class Point {
    int r, c;

    public Point (int r, int c) {
        this.r = r;
        this.c = c;
    }
}