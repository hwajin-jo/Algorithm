package baekjoon.no14235;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            if (a == 0) {
                if (!pq.isEmpty())
                    bw.write(pq.poll() + " \n");
                else
                    bw.write(-1 + "\n");
            } else {
                while (a-- > 0) {
                    pq.add(Integer.parseInt(st.nextToken()));
                }
            }
        }

        bw.flush();
        bw.close();
    }
}
