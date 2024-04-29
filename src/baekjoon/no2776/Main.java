package baekjoon.no2776;

import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            HashSet<Integer> set = new HashSet<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                set.add(Integer.parseInt(st.nextToken()));
            }

            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                if (set.contains(Integer.parseInt(st.nextToken()))) {
                    bw.write(1 + "\n");
                } else {
                    bw.write(0 + "\n");
                }
            }
        }
        bw.flush();
        bw.close();
    }
}
