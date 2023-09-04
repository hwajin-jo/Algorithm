package baekjoon.no18870;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[] origin = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        TreeSet<Integer> sortedSet = new TreeSet<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            origin[i] = Integer.parseInt(st.nextToken());
            sortedSet.add(origin[i]);
        }

        int cnt = 0;

        for (int s : sortedSet) {
            map.put(s, cnt++);
        }


        for (int i = 0; i < n; i++) {
            bw.write(map.get(origin[i]) + " ");
        }
        bw.write("\n");
        bw.flush();
        bw.close();

    }
}
