package baekjoon.no18113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] len = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int input = Integer.parseInt(st.nextToken());

            if (input < k)
                len[i] = 0;
            else if (input < 2 * k)
                len[i] = input - k;
            else
                len[i] = input - 2*k;
        }

        Arrays.sort(len);

        int start = 1;
        int end = len[n - 1];

        int ans = -1;

        while (start <= end) {
            int mid = (start + end) / 2;
            int cnt = 0;
            for (int i = 0; i < len.length; i++) {
                cnt += len[i] / mid;
            }

            if (cnt >= m) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(ans);
    }
}
