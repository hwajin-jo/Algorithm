package baekjoon.no25;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, String> hashMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String[] data = br.readLine().split(" ");
            hashMap.put(data[0], data[1]);
        }

        for (int i = 0; i < M; i++) {
            String website = br.readLine();
            bw.write(hashMap.get(website) + "\n");
        }

        bw.flush();
        bw.close();
    }
}
