package baekjoon.no2346;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        ArrayDeque<Balloon> dq = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            int move = sc.nextInt();
            dq.offer(new Balloon(i + 1, move));
        }

        StringBuilder sb = new StringBuilder();
        while (!dq.isEmpty()) {
            int move = dq.peekFirst().move;
            int idx = dq.pollFirst().idx;

            sb.append(idx).append(" ");

            if (dq.isEmpty()) break;

            if (move < 0) {
                for (int i = 0; i < -move; i++)
                    dq.offerFirst(dq.pollLast());
            } else {
                for (int i = 0; i < move - 1; i++)
                    dq.offerLast(dq.pollFirst());
            }
        }

        System.out.println(sb);
    }
}

class Balloon {
    int idx;
    int move;

    public Balloon (int idx, int move) {
        this.idx = idx;
        this.move = move;
    }
}
