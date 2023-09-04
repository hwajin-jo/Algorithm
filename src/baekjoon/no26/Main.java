package baekjoon.no26;

import java.io.*;
import java.util.*;

// 13335 - 트럭
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 트럭의 수
        int W = Integer.parseInt(st.nextToken()); // 다리의 길이
        int L = Integer.parseInt(st.nextToken()); // 최대하중

        Queue<Integer> truck = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            truck.offer(Integer.parseInt(st.nextToken()));
        }

        Queue<Integer> bridge = new LinkedList<>();

        for (int i = 0; i < W; i++) {
            bridge.offer(0);
        }

        int time = 0;
        int sum = 0;

        while (!bridge.isEmpty()) {
            time++;
            sum -= bridge.poll();

            if (!truck.isEmpty()) {
                int weight = truck.peek();

                if (sum + weight <= L) {
                    int newtruck = truck.poll();
                    sum += newtruck;
                    bridge.offer(newtruck);
                } else {
                    bridge.offer(0);
                }
            }
        }


        bw.write(time + "\n");
        bw.flush();
        bw.close();
    }
}
