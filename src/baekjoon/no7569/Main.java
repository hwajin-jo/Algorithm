package baekjoon.no7569;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int H = sc.nextInt();

        int[] dh = {-1, 1, 0, 0, 0, 0};
        int[] dr = {0, 0, -1, 1, 0, 0};
        int[] dc = {0, 0, 0, 0, -1, 1};

        int[][][] arr = new int[H][M][N];
        boolean[][][] visited = new boolean[H][M][N];

        Queue<Point> q = new LinkedList<>();
        for (int k = 0; k < H; k++) {
            for (int j = 0; j < M; j++) {
                for (int i = 0; i < N; i++) {
                    arr[k][j][i] = sc.nextInt();

                    if (arr[k][j][i] == 1) {
                        q.add(new Point(i, j, k, arr[k][j][i]));
                        visited[k][j][i] = true;
                    }
                }
            }
        }

        boolean isZero = false;
        for (int k = 0; k < H; k++) {
            for (int j = 0; j < M; j++) {
                for (int i = 0; i < N; i++) {
                    if (arr[k][j][i] == 0) {
                        isZero = true;
                    }
                }
            }
        }

        if (!isZero) {
            System.out.println(0);
            return;
        }

        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int i = 0; i < 6; i++) {
                int nx = now.i + dr[i];
                int ny = now.j + dc[i];
                int nz = now.k + dh[i];

                if (nx < 0 || ny < 0 || nz < 0 || nx >= N || ny >= M || nz >= H) continue;
                if (arr[nz][ny][nx] != 0) continue;
                if (!visited[nz][ny][nx]) {
                    visited[nz][ny][nx] = true;
                    arr[nz][ny][nx] = now.data + 1;
                    q.add(new Point(nx, ny, nz, now.data + 1));
                }
            }
        }

        for (int k = 0; k < H; k++) {
            for (int j = 0; j < M; j++) {
                for (int i = 0; i < N; i++) {
                    if (arr[k][j][i] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        int days = 0;
        for (int k = 0; k < H; k++) {
            for (int j = 0; j < M; j++) {
                for (int i = 0; i < N; i++) {
                    days = Math.max(days, arr[k][j][i]);
                }
            }
        }

        System.out.println(days - 1);
    }
}

class Point {
    int i, j, k;
    int data;

    public Point(int i, int j, int k, int data) {
        this.i = i;
        this.j = j;
        this.k = k;
        this.data = data;
    }
}
