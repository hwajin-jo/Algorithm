package baekjoon.no11004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0;i < N; i++) {
            pq.add(Integer.parseInt(st.nextToken()));
        }

        while (K-- > 1) {
            pq.poll();
        }

        System.out.println(pq.peek());


    }
}
