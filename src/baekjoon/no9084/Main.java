package baekjoon.no9084;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[] coins = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int[] dp = new int[M + 1];

            dp[0] = 1; // 0원을 만드는 방법은 아무 동전도 사용하지 않는 1가지 밖에 없다.

            // 0 ~ i 번째 동전까지 사용했을 때, j원을 만들 수 있는 방법의 수를 dp에 저장
            for (int i = 0; i < N; i++) {
                for (int j = coins[i]; j <= M; j++) {
                    dp[j] += dp[j - coins[i]];
                }
            }


            System.out.println(dp[M]);
        }
    }
}
