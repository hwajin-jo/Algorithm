package baekjoon.no11659;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in ));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];
        int[] prefixSum = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i]= Integer.parseInt(st.nextToken());
        }

        // 구간합 구하기

        for (int i = 1; i <= N; i++) {
            prefixSum[i]= prefixSum[i - 1] + arr[i];
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            bw.write(prefixSum[end] - prefixSum[start - 1] + " \n");
        }

        bw.flush();
        bw.close();
    }
}
