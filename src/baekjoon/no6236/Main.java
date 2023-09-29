package baekjoon.no6236;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] money = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            money[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(money);

        int left = 1, right = 1000000000;

        int K = -1;
        while (left <= right) {
            int mid = (left + right) / 2;

            int cnt = 1;
            int wallet = mid;
            for (int i = 0; i < money.length; i++) {
                if (wallet - money[i] < 0) {
                    wallet = mid;
                    cnt++;
                }
                wallet -= money[i];
            }

            if (cnt > M) {
                left = mid + 1;
            } else {
                K = mid;
                right = mid - 1;
            }
        }

        System.out.println(K);
    }
}
