package baekjoon.no5014;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int F = sc.nextInt();
        int S = sc.nextInt();
        int G = sc.nextInt();
        int U = sc.nextInt();
        int D = sc.nextInt();

        boolean[] visited = new boolean[F + 1];

        visited[S] = true;

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(S, 0));

        int ans = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            Point now = q.poll();

            if (now.idx == G) {
                ans = Math.min(ans, now.cnt);
            }

            int up = now.idx + U;
            int down = now.idx - D;
            if (!isInvalid(F, visited, up)) {
                visited[up] = true;
                q.add(new Point(up, now.cnt + 1));
            }

            if (!isInvalid(F, visited, down)) {
                visited[down] = true;
                q.add(new Point(down, now.cnt + 1));
            }

        }

        if (ans == Integer.MAX_VALUE) {
            System.out.println("use the stairs");
        } else {
            System.out.println(ans);
        }

    }

    private static boolean isInvalid(int F, boolean[] visited, int next) {
        if (next < 1 || next > F) return true;
        if (visited[next]) return true;
        return false;
    }
}

class Point {
    int idx;
    int cnt;

    public Point (int idx, int cnt) {
        this.idx = idx;
        this.cnt = cnt;
    }
}
