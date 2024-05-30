package baekjoon.no18405;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[][] arr = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparingInt(o -> arr[o.r][o.c]));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();

                if (0 < arr[i][j] && arr[i][j] <= k) {
                    pq.add(new Point(i, j));
                }
            }
        }

        int s = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();


        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        int cnt = 0;

        while (cnt < s) {
            cnt++;
            while (!pq.isEmpty()) {
                Point now = pq.poll();
                visited[now.r][now.c] = true;
                for (int d = 0; d < 4; d++) {
                    int nr = now.r + dr[d];
                    int nc = now.c + dc[d];

                    if (nr < 0 || nc < 0 || nr >= n || nc >= n) continue;
                    if (arr[nr][nc] != 0) continue;
                    arr[nr][nc] = arr[now.r][now.c];
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] > 0 && !visited[i][j])
                        pq.add(new Point(i, j));
                }
            }
        }

        System.out.println(arr[x - 1][y - 1]);
    }
}

class Point {
    int r, c;
    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }

}
