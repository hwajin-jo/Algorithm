package baekjoon.no14728;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[][] exam = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            exam[i][0] = Integer.parseInt(st.nextToken());
            exam[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[T + 1];
        for (int i = 0; i < exam.length; i++) {
            for (int j = T; j >= exam[i][0]; j--) {
                dp[j] = Math.max(dp[j], dp[j - exam[i][0]] + exam[i][1]);
            }
        }

        System.out.println(dp[T]);
    }
}
