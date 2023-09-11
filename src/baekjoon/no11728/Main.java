package baekjoon.no11728;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        int[] B = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[N + M];

        int aIdx = 0;
        int bIdx = 0;

        for (int i = 0; i < result.length; i++) {
            if (aIdx == N) {
                result[i] = B[bIdx++];
            } else if (bIdx == M) {
                result[i] = A[aIdx++];
            } else {
                if (A[aIdx] > B[bIdx]) {
                    result[i] = B[bIdx++];
                } else if (A[aIdx] < B[bIdx]) {
                    result[i] = A[aIdx++];
                } else {
                    result[i++] = A[aIdx++];
                    result[i] = B[bIdx++];
                }
            }
        }

        for (int i = 0; i < result.length; i++) {
            bw.write(result[i] + " ");
        }
        bw.write("\n");

        bw.flush();
        bw.close();
    }
}
