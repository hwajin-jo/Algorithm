package baekjoon.no2470;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        int[] result = new int[2];

        int start = 0;
        int end = arr.length - 1;

        long min = Long.MAX_VALUE;
        while (start <= end) {
            long sum = arr[start] + arr[end];

            if (sum == 0) {
                result[0] = arr[start];
                result[1] = arr[end];
                break;
            }

            if (min > Math.abs(sum)) {
                min = sum;
                result[0] = arr[start];
                result[1] = arr[end];
            }

            if (sum > 0) end--;
            else start++;
        }

        System.out.println(result[0] + " " + result[1]);
    }
}
