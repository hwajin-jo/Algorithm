package baekjoon.no5648;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int n = Integer.parseInt(st.nextToken());

        List<String> list = new ArrayList<>();

        while (n > 0) {
            if (st.hasMoreTokens()) {
                StringBuilder sb = new StringBuilder(st.nextToken());
                sb.reverse();

                StringBuilder res = new StringBuilder();
                for (int i = 0; i < sb.length(); i++) {
                    if (sb.charAt(i) == '0' && res.length() == 0) continue;
                    res.append(sb.charAt(i));
                }

                list.add(res.toString());
                n--;
            } else {
                st = new StringTokenizer(br.readLine());
            }

        }

        list.sort((o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }
            return o1.length() - o2.length();
        });

        for (String data : list) {
            bw.write(data + "\n");
        }
        bw.write("\n");
        bw.flush();
        bw.close();
    }
}
