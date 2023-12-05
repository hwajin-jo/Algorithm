package baekjoon.no17225;

import java.util.*;

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
                if (!blueQ.isEmpty() && blueQ.getLast() + bTime > time) {
                    time = blueQ.getLast() + bTime;
                }
                for (int j = 0; j < cnt; j++) {
                    blueQ.offer(time);
                    time += bTime;
                }
                break;
                case 'R':
                    if (!redQ.isEmpty() && redQ.getLast() + rTime > time) {
                        time = redQ.getLast() + rTime;
                    }
                    for (int j = 0; j < cnt; j++) {
                        redQ.offer(time);
                        time += rTime;
                    }
                    break;
            }
        }

        List<Integer> blueOrder = new LinkedList<>();
        List<Integer> redOrder = new LinkedList<>();
        int orderNumber = 0;

        while (!blueQ.isEmpty() && !redQ.isEmpty()) {
            if (blueQ.peek() <= redQ.peek()) {
                blueQ.poll();
                blueOrder.add(++orderNumber);
            } else {
                redQ.poll();
                redOrder.add(++orderNumber);
            }
        }

        while (!blueQ.isEmpty()) {
            blueQ.poll();
            blueOrder.add(++orderNumber);
        }

        while (!redQ.isEmpty()) {
            redQ.poll();
            redOrder.add(++orderNumber);
        }

        System.out.println(blueOrder.size());

        for (Integer order : blueOrder) {
            System.out.print(order + " ");
        }
        System.out.println();

        System.out.println(redOrder.size());

        for (Integer order : redOrder) {
            System.out.print(order + " ");
        }
        System.out.println();
    }
}