package baekjoon.no6593;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] dl = {-1, 1};
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (true) {
            int L = sc.nextInt();
            int R = sc.nextInt();
            int C = sc.nextInt();

            if (L == 0 && R == 0 && C == 0) break;

            char[][][] buildings = new char[L][R][C];
            int[][][] visited = new int[L][R][C];
            Queue<Point> q = new LinkedList<>();
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String input = sc.next();
                    for (int k = 0; k < C; k++) {
                        buildings[i][j][k] = input.charAt(k);
                        if (buildings[i][j][k] == 'S') {
                            q.add(new Point(i, j, k));
                        }
                    }
                }
                sc.nextLine();
            }

            int time = 0;
            while (!q.isEmpty()) {
                Point now = q.poll();

                if (buildings[now.l][now.r][now.c] == 'E') {
                    time = visited[now.l][now.r][now.c];
                    break;
                }

                for (int d = 0; d < 4; d++) {
                    int nr = now.r + dr[d];
                    int nc = now.c + dc[d];

                    if (nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
                    if (visited[now.l][nr][nc] > 0) continue;
                    if (buildings[now.l][nr][nc] == '#') continue;
                    visited[now.l][nr][nc] = visited[now.l][now.r][now.c] + 1;
                    q.add(new Point(now.l, nr, nc));
                }

                for (int d = 0; d < 2; d++) {
                    int nl = now.l + dl[d];

                    if (nl < 0 || nl >= L) continue;
                    if (visited[nl][now.r][now.c] > 0) continue;
                    if (buildings[nl][now.r][now.c] == '#') continue;
                    visited[nl][now.r][now.c] = visited[now.l][now.r][now.c] + 1;
                    q.add(new Point(nl, now.r, now.c));
                }
            }

            if (time == 0) {
                System.out.println("Trapped!");
            } else {
                System.out.printf("Escaped in %d minute(s).\n", time);
            }

        }
    }
}

class Point {
    int l, r, c;

    public Point (int l, int r, int c) {
        this.l = l;
        this.r = r;
        this.c = c;
    }
}