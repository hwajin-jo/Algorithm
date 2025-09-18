package baekjoon.no15649;

import java.util.*;

public class Main {

    static int N, M;
    static int[] arr;
    static int[] temp;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N];
        visited = new boolean[N];
        temp = new int[M];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        solution(0, 0);
        System.out.println(sb);
    }

    public static void solution(int depth, int now) {
        if (depth == M) {
            for (int i = 0; i < temp.length; i++) {
                sb.append(temp[i]).append(" ");
            }

            sb.append("\n");

            return;
        }

        for (int i = now; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                temp[depth] = arr[i];
                solution(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }

}


