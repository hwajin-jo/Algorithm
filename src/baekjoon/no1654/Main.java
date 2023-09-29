package baekjoon.no1654;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] lines = new int[K];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            lines[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(lines);

        long left = 1;
        long right = (1L << 31) - 1;

        long answer = -1 ;
        while (left <= right) {
            long mid = (left + right) / 2;


            int cnt = 0;
            for (int i = 0; i < lines.length; i++) {
                cnt += lines[i] / mid;
            }

            if (cnt < N) right = mid - 1;
            else {
                answer = mid;
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }
}
