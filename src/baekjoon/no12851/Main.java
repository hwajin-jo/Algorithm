package baekjoon.no12851;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] visited = new int[100001];
        int[] count = new int[100001];

        Queue<Integer> q = new LinkedList<>();
        int ans = Integer.MAX_VALUE;
        q.add(n);
        visited[n] = 1;
        count[n] = 1;
        while (!q.isEmpty()) {
            int now = q.poll();

            if (now == k) {
                ans = Math.min(ans, visited[now]);
            }

            int[] step = {now - 1, now + 1, now * 2};

            for (int i = 0; i < 3; i++) {
                if (isRange(step[i])) {
                    if (visited[step[i]] == 0) {
                        visited[step[i]] = visited[now] + 1;
                        count[step[i]] = count[now];
                        q.add(step[i]);
                    } else if (visited[step[i]] == visited[now] + 1) {
                       count[step[i]] += count[now];
                    }
                }
            }
        }

        System.out.println(ans - 1);
        System.out.println(count[k]);

    }

    static boolean isRange(int step) {
        return step >= 0 && step <= 100000;
    }
}
