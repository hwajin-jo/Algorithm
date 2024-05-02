package baekjoon.no2467;

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
        int near_start = 0;
        int near_end = 0;
        while (start < end) {
            int mid = arr[start] + arr[end];

            if (mid == 0) {
                near_start = start;
                near_end = end;
                break;
            } else if (mid < 0) {
                if (Math.abs(ans) > Math.abs(mid)) {
                    ans = mid;
                    near_start = start;
                    near_end = end;
                }
                start++;
            } else {
                if (Math.abs(ans) > Math.abs(mid)) {
                    ans = mid;
                    near_start = start;
                    near_end = end;
                }
                end--;
            }
        }

        System.out.println(arr[near_start] + " " + arr[near_end]);
    }
}
