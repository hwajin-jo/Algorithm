package baekjoon.no23;

import java.util.*;
// 1021 - 회전하는 큐
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[m];

        for (int i = 0; i < m; i++) {
            arr[i] = sc.nextInt();
        }
        LinkedList<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        int i = 0;
        int cnt = 0;
        while (q.size() > n - m) {
            if (q.peek() == arr[i]) {
                q.poll();
                i++;
            } else {
                if (q.indexOf(arr[i]) <= q.size()/2) {
                    q.offer(q.poll());
                } else {
                    q.offerFirst(q.pollLast());
                }
                cnt++;
            }

        }

        System.out.println(cnt);
    }
}
