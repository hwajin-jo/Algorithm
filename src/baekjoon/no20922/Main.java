package baekjoon.no20922;

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
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = -1;
        int start = 0;
        int[] cnt = new int[100001];

        for (int i = 0; i < n; i++) {
            cnt[arr[i]]++;
            if (cnt[arr[i]] > k) {
                for (int j = start; j < i; j++) {
                    cnt[arr[j]]--;
                    if (arr[i] == arr[j]) {
                        start = j + 1;
                        break;
                    }
                }
            }

            max = Math.max(max, i - start + 1);
        }

        System.out.println(max);
    }
}
