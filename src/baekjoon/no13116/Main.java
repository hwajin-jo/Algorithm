package baekjoon.no13116;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int ans = 0;
            while (true) {
                if (a > b) {
                    a /= 2;
                } else if (a < b) {
                    b /= 2;
                } else if (a == b) {
                    ans = a;
                    break;
                }
            }

            bw.write(ans * 10 + "\n");
        }

        bw.flush();
        bw.close();
    }
}
