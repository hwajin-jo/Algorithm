package baekjoon.no13549;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] data = br.readLine().split(" ");

        int N = Integer.parseInt(data[0]);
        int K = Integer.parseInt(data[1]);

        int[] dp = new int[1000001];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[N] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(N);

        while (!q.isEmpty()) {
            int now = q.poll();

            if (isValid(now + 1) && dp[now + 1] > dp[now] + 1) {
                dp[now + 1] = dp[now] + 1;
                q.add(now + 1);
            }

            if (isValid(now - 1) && dp[now - 1] > dp[now] + 1) {
                dp[now - 1] = dp[now] + 1;
                q.add(now - 1);
            }

            if (isValid(now * 2) && dp[now * 2] > dp[now]) {
                dp[2 * now] = dp[now];
                q.add(now * 2);
            }
        }
        System.out.println(dp[K]);
    }

    private static boolean isValid(int data) {
        return 0 <= data && data <= 100000;
    }
}
