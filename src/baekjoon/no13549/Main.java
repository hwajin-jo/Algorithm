package baekjoon.no13549;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        boolean[] visited = new boolean[100001];

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(N, 0));
        visited[N] = true;

        int ans = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            Point now = q.poll();

            if (now.data == K) {
                ans = Math.min(ans, now.cnt);
            }

            int prev = now.data - 1;
            int next = now.data + 1;
            int jump = now.data * 2;

            if (isValid(jump) && !visited[jump]) {
                visited[jump] = true;
                q.add(new Point(jump, now.cnt));
            }

            if (isValid(prev) && !visited[prev]) {
                visited[prev] = true;
                q.add(new Point(prev, now.cnt + 1));
            }
            if (isValid(next) && !visited[next]) {
                visited[next] = true;
                q.add(new Point(next, now.cnt + 1));
            }
        }

        System.out.println(ans);
    }

    static boolean isValid(int data) {
        return (0 <= data) && (data <= 100000);
    }
}

class Point {
    int data;
    int cnt;
    public Point(int data, int cnt) {
        this.data = data;
        this.cnt = cnt;
    }
}
