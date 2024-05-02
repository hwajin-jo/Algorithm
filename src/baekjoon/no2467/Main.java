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
        int ansStart = 0;
        int ansEnd = 0;
        while (start < end) {
            int mid = Math.abs(arr[start] + arr[end]);

            if (ans > mid) {
                ans = mid;
                ansStart = start;
                ansEnd = end;
            }

            if (Math.abs(arr[start]) < arr[end]) {
                end--;
            } else {
                start++;
            }
        }

        System.out.println(arr[ansStart] + " " + arr[ansEnd]);
    }
}
