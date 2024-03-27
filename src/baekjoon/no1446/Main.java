package baekjoon.no1446;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int d = sc.nextInt();

        List<Road> roadList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int length = sc.nextInt();

            if (end > d) continue;
            if (end - start < length) continue;
            roadList.add(new Road(start, end, length));
        }
        int[] dp = new int[d + 1];

        for (int i = 1; i <= d; i++) {
            dp[i] = dp[i - 1] + 1;
            for (Road road : roadList) {
                if (i == road.end) {
                    if (dp[i] > dp[road.start] + road.length)
                        dp[i] = dp[road.start] + road.length;
                }
            }

        }



        System.out.println(dp[d]);
    }
}

class Road {
    int start;
    int end;
    int length;

    public Road(int start, int end, int length) {
        this.start = start;
        this.end = end;
        this.length = length;
    }
}