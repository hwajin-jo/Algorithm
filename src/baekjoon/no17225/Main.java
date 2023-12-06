package baekjoon.no17225;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int bTime = sc.nextInt();
        int rTime = sc.nextInt();
        int n = sc.nextInt();

        Deque<Integer> blueQ = new LinkedList<>();
        Deque<Integer> redQ = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            int time = sc.nextInt();
            char color = sc.next().charAt(0);
            int cnt = sc.nextInt();

            switch (color) {
                case 'B':
                    for (int j = 0; j < cnt; j++) {
                        if (blueQ.isEmpty()) {
                            blueQ.offer(time);
                        } else {
                            if (blueQ.getLast() + bTime > time) {
                                time = blueQ.getLast() + bTime;
                                blueQ.offer(time);
                            } else {
                                blueQ.offer(time);
                            }
                        }
                        time += bTime;
                    }
                    break;
                case 'R':
                    for (int j = 0; j < cnt; j++) {
                        if (redQ.isEmpty()) {
                            redQ.offer(time);
                        } else {
                            if (redQ.getLast() + rTime > time) {
                                time = redQ.getLast() + rTime;
                                redQ.offer(time);
                            } else {
                                redQ.offer(time);
                            }
                        }
                        time += rTime;
                    }
                    break;
            }
        }

        int orderNumber = 0;
        List<Integer> blueList = new LinkedList<>();
        List<Integer> redList = new LinkedList<>();

        while (!blueQ.isEmpty() && !redQ.isEmpty()) {
            if (blueQ.peek() <= redQ.peek()) {
                blueQ.poll();
                blueList.add(++orderNumber);
            } else {
                redQ.poll();
                redList.add(++orderNumber);
            }
        }

        while (!blueQ.isEmpty()) {
            blueQ.poll();
            blueList.add(++orderNumber);
        }

        while (!redQ.isEmpty()) {
            redQ.poll();
            redList.add(++orderNumber);
        }

        System.out.println(blueList.size());

        for (Integer num : blueList) {
            System.out.print(num + " ");
        }

        System.out.println();

        System.out.println(redList.size());

        for (Integer num : redList) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
