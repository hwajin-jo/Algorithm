package baekjoon.no10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 10845 - 큐
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            if (str.equals("push")) {
                int input = Integer.parseInt(st.nextToken());
                deque.offerLast(Integer.valueOf(input));
            } else if (str.equals("pop")) {
                if (deque.isEmpty()) System.out.println(-1);
                else {
                    int output = deque.pollFirst();
                    System.out.println(output);
                }
            } else if (str.equals("size")) {
                System.out.println(deque.size());
            } else if (str.equals("empty")) {
                if (deque.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if (str.equals("front")) {
                if (deque.isEmpty()) {
                    System.out.println(-1);
                } else {
                    int output = deque.peekFirst();
                    System.out.println(output);
                }
            } else if (str.equals("back")) {
                if (deque.isEmpty()) {
                    System.out.println(-1);
                } else {
                    int output = deque.peekLast();
                    System.out.println(output);
                }
            }
        }
    }
}
