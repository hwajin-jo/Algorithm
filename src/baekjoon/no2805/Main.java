package baekjoon.no2805;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] tree = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }

        int l = 1;
        int r = tree[N - 1];

        int H = 0;
        while (l <= r) {
            int m = (l + r) / 2;

            long total = 0;
            for (int i = 0; i < tree.length; i++) {
                int cutting = tree[i] - m;
                if (cutting >= 0) {
                    total += cutting;
                }
            }

            if (total < M) r = m - 1;
            else {
                H = m;
                l = m + 1;
            }
        }

        System.out.println(H);
    }
}
