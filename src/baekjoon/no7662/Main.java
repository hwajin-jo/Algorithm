package baekjoon.no7662;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine());

            TreeMap<Integer, Integer> treeMap = new TreeMap<>();
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                String cmd = st.nextToken();
                int data = Integer.parseInt(st.nextToken());
                if (cmd.equals("I")) {
                    treeMap.put(data, treeMap.getOrDefault(data, 0) + 1);
                } else {
                    if (treeMap.isEmpty()) continue;

                    int key;
                    if (data < 0) {
                        key = treeMap.firstKey();
                    } else {
                        key = treeMap.lastKey();
                    }

                    int cnt = treeMap.get(key);
                    if (cnt == 1)
                        treeMap.remove(key);
                    else
                        treeMap.put(key, treeMap.get(key) - 1);
                }
            }

            if (treeMap.isEmpty())
                bw.write("EMPTY\n");
            else
                bw.write(treeMap.lastKey() + " " + treeMap.firstKey() + "\n");
        }

        bw.flush();
        bw.close();
    }
}
