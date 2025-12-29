package baekjoon.no29718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[M][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                arr[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());

        int[] sum = new int[M];

        for (int i = 0; i < M; i++) {
            int rowSum = 0;
            for (int j = 0; j < N; j++) {
                rowSum += arr[i][j];
            }

            sum[i] = rowSum;
        }

        int total = 0;
        int start = 0;
        int end = A - 1;

        for (int i = start; i <= end; i++) {
            total += sum[i];
        }

        int ans = total;
        while (end < M - 1) {
            total -= sum[start++];
            total += sum[++end];

            ans = Math.max(ans, total);
        }

        System.out.println(ans);
    }
}
