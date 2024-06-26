package baekjoon.no1270;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
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
            Map<Long, Long> map = new HashMap<>();

            for (int i = 0; i < n; i++) {
                long num = Long.parseLong(st.nextToken());
                map.put(num, map.getOrDefault(num, 0L) + 1);
            }

            boolean flag = true;
            for (Map.Entry<Long, Long> entry : map.entrySet()) {
                if (entry.getValue() > n / 2) {
                    bw.write(entry.getKey() + "\n");
                    flag = false;
                    break;
                }
            }

            if (flag)
                bw.write("SYJKGW" + "\n");
        }

        bw.flush();
        bw.close();
    }
}
