package baekjoon.no2015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] sum = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(st.nextToken());
            sum[i] = sum[i - 1] + num; // 누적합 구하기
        }

        /*
            i ~ j 까지의 합을 구할 때,
            sum[i] - sum[j] = K 를 만족하는 경우를 구한다.
            K - sum[j] = sum[i] 인 경우의 수를 구해준다.
         */
        long ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            if (sum[i] == K) ans++; // 해당 누적합 구간자체도 넣어줘야함
            ans += map.getOrDefault(sum[i] - K, 0); // sum[i] - K 가 존재하면 구하기
            map.put(sum[i], map.getOrDefault(sum[i], 0) + 1); // sum[i]값 저장
        }

        System.out.println(ans);
    }
}
