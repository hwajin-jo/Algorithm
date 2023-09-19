package baekjoon.no15656;

import java.io.*;
import java.util.Arrays;

public class Main {
    static int N, M;
    static int[] arr, save;
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] data = br.readLine().split(" ");
        N = Integer.parseInt(data[0]);
        M = Integer.parseInt(data[1]);

        arr = new int[N];
        visited = new boolean[N];

        data = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(data[i]);
        }

        Arrays.sort(arr);

        save = new int[M];
        permutation(0);

        System.out.println(sb);
    }

    static void permutation(int depth) {
        if (depth == M) {

            for (int i = 0; i < M; i++) {
                sb.append(save[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            save[depth] = arr[i];
            permutation(depth + 1);
        }
    }
}