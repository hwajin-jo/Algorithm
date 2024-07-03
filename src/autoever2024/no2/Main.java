package autoever2024.no2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 최고의 팀워크
public class Main {
    public static void main(String[] args) {
        int n = 5; // 물건의 갯수
        int k = 2; // 사람의 수 (1 이상 3 이하)
        int m = 5; // 각 가방에 담을 수 있는 최대 무게

        // 보급품의 무게와 가치
        int[][] items = {
                {4, 5},
                {3, 4},
                {2, 1},
                {5, 7},
                {1, 1}
        };

        System.out.println(maxValue(n, k, m, items));
    }

    public static int maxValue(int n, int k, int m, int[][] items) {
        // dp 배열 초기화: 각 사람에 대해 각각의 최대 무게를 고려
        int[][] dp = new int[k + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            int weight = items[i - 1][0];
            int value = items[i - 1][1];
            // 현재 아이템을 한 사람이 선택한 경우를 고려하여 역순으로 처리
            for (int person = k; person >= 1; person--) {
                for (int currentWeight = m; currentWeight >= weight; currentWeight--) {
                    dp[person][currentWeight] = Math.max(dp[person][currentWeight], dp[person - 1][currentWeight - weight] + value);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < k; i++) {
            ans += dp[i][m];
        }
        return ans;
    }
}

