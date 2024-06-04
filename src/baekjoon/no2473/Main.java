package baekjoon.no2473;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        long[] arr = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        long min_diff = Long.MAX_VALUE;
        long[] res = new long[3];
        for (int left = 0; left < n; left++) {
            int mid = left + 1;
            int right = n - 1;

            while (mid < right) {
                long sum = arr[left] + arr[mid] + arr[right];

                long cur_diff = Math.abs(sum);

                if (cur_diff < min_diff) {
                    min_diff = cur_diff;
                    res[0] = arr[left];
                    res[1] = arr[mid];
                    res[2] = arr[right];
                }

                if (sum > 0) {
                    right--;
                } else {
                    mid++;
                }
            }
        }
        System.out.println(res[0] + " " + res[1] + " " + res[2]);
    }
}
