package baekjoon.no12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.StringTokenizer;

// 10866 - 덱
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String input = st.nextToken();

            if (input.equals("push_front")) {
                int num = Integer.parseInt(st.nextToken());
                deque.offerFirst(num);
            } else if (input.equals("push_back")) {
                int num = Integer.parseInt(st.nextToken());
                deque.offerLast(num);
            } else if (input.equals("pop_front")) {
                if (deque.isEmpty()) {
                    System.out.println(-1);
                } else {
                    int output = deque.pollFirst();
                    System.out.println(output);
                }
            } else if (input.equals("pop_back")) {
                if (deque.isEmpty()) {
                    System.out.println(-1);
                } else {
                    int output = deque.pollLast();
                    System.out.println(output);
                }
            } else if (input.equals("size")) {
                System.out.println(deque.size());
            } else if (input.equals("empty")) {
                if (deque.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if (input.equals("front")) {
                if (deque.isEmpty()) {
                    System.out.println(-1);
                } else {
                    int output = deque.peekFirst();
                    System.out.println(output);
                }
            } else if (input.equals("back")) {
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
