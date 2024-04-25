package baekjoon.no14921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = n - 1;

        int ans = Integer.MAX_VALUE;
        while (start < end) {
            int sum = arr[start] + arr[end];
            if (Math.abs(ans) > Math.abs(sum)) {
                ans = sum;
            }

            if (sum >= 0) {
                end--;
            } else {
                start++;
            }
        }

        System.out.println(ans);
    }
}
