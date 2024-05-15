package baekjoon.no22233;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            set.add(st.nextToken());
        }

        for (int i = 0; i < m ; i++) {
            st = new StringTokenizer(br.readLine());
            String[] input = st.nextToken().split(",");

            for (String s : input) {
                set.remove(s);
            }

            bw.write(set.size() + " \n");
        }

        bw.flush();
        bw.close();
    }
}
