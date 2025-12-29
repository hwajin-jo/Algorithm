package baekjoon.no12847;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] work = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            work[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = m - 1;

        long sum = 0;
        for (int i = start; i <= end; i++) {
            sum += work[i];
        }

        long max = sum;

        while (end < n) {
            sum -= work[start++];
            sum += work[++end];

            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}
