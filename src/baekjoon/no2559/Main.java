package baekjoon.no2559;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        int start = 0;
        int end = k - 1;

        int sum = 0;

        for (int i = start; i <= end; i++) {
            sum += arr[i];
        }

        int max = sum;

        while (end < n - 1) {
            sum -= arr[start++];
            sum += arr[++end];

            max = Math.max(sum, max);
        }
        System.out.println(max);
    }
}
