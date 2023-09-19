package baekjoon.no15657;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N, M;
    static int[] numbers, save;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }

        save = new int[M];
        Arrays.sort(numbers);

        combination(0, 0);

        System.out.println(sb);
    }

    static void combination(int depth, int start) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(save[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < N; i++) {
            save[depth] = numbers[i];
            combination(depth+1, i);
        }
    }
}
