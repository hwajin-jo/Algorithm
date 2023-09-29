package baekjoon.no9372;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][] plane;
    static boolean[] visit;
    static int N, M, result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        // bfs
        for (int i = 0; i < T; i++) {
            N = sc.nextInt();
            M = sc.nextInt();
            result = 0;

            plane = new int[N+1][N+1];
            visit = new boolean[N+1];

            for (int j = 0; j < M; j++) {
                int a = sc.nextInt();
                int b = sc.nextInt();

                plane[a][b] = 1;
                plane[b][a] = 1;
            }

            bfs();
            System.out.println(result - 1);
        }
    }

    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();

        q.add(1);
        visit[1] = true;

        while (!q.isEmpty()) {
            result++;
            int value = q.poll();
            for (int i = 1; i <= N; i++) {
                if (plane[value][i] != 0 && !visit[i]) {
                    visit[i] = true;
                    q.add(i);
                }
            }
        }
    }
}
