package baekjoon.no17845;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 최대 공부시간
        int K = Integer.parseInt(st.nextToken()); // 과목 수

        int[][] subjects = new int[K][2];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int I = Integer.parseInt(st.nextToken()); // 중요도
            int T = Integer.parseInt(st.nextToken()); // 필요 공부시간
            subjects[i][0] = I;
            subjects[i][1] = T;
        }

        int[] dp = new int[N + 1];

        for (int i = 0; i < subjects.length; i++) {
            for (int j = N; j >= subjects[i][1]; j--) {
                dp[j] = Math.max(dp[j], dp[j - subjects[i][1]] + subjects[i][0]);
            }
        }

        System.out.println(dp[N]);
    }
}
