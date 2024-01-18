package baekjoon.no3584;

import java.util.Scanner;

public class Main {

    static int[] parents;
    static boolean[] check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();

            parents = new int[N + 1];
            check = new boolean[N + 1];
            for (int i = 0; i < N - 1; i++) {
                int A = sc.nextInt();
                int B = sc.nextInt();

                parents[B] = A;
            }

            int node1 = sc.nextInt();
            int node2 = sc.nextInt();

            while (node1 != 0) {
                check[node1] = true;

                node1 = parents[node1];
            }

            int ans;
            while (true) {
                if (check[node2]) {
                    ans = node2;
                    break;
                }

                node2 = parents[node2];
            }

            System.out.println(ans);
        }
    }
}
