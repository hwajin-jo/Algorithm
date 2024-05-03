package baekjoon.no13144;

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

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int[] cnt = new int[100001];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long ans = 0;
        int s = 0, e = 0;
        cnt[arr[e]]++;
        while (s <= e && e <= n - 1) {
            ans += e - s + 1;
            e++;
            if (e <= n - 1) {
                cnt[arr[e]]++;

                while (cnt[arr[e]] >= 2) {
                    cnt[arr[s]]--;
                    s++;
                }
            }

        }

        System.out.println(ans);
    }
}
