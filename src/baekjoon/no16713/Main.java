package baekjoon.no16713;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    /*
        5 4
        4 4 2 1 0
        1 1
        1 2
        1 3
        2 4
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];
        int[] acc = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n+1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            acc[i] = acc[i-1] ^ arr[i];
        }

        int answer = 0;
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int result = acc[end] ^ acc[start-1];
            answer = result ^ answer;
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }
}
