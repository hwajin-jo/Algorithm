package baekjoon.no13414;

import java.io.*;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        LinkedHashSet<String> set = new LinkedHashSet<>();
        while (l--> 0) {
            st = new StringTokenizer(br.readLine());
            String data = st.nextToken();
            if (set.contains(data)) {
                set.remove(data);
                set.add(data);
            } else {
                set.add(data);
            }
        }

        int cnt = 0;
        for (String str : set) {
            if (cnt == k) break;
            bw.write(str + "\n");
            cnt++;
        }

        bw.flush();
        bw.close();
    }
}
