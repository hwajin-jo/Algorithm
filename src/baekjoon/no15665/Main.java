package baekjoon.no15665;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    static int N, M;
    static int[] arr;
    static int[] temp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N];
        temp = new int[M];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        backtracking(0);
    }

    static void backtracking(int depth) {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < temp.length; i++) {
                sb.append(temp[i]).append(" ");
            }

            System.out.println(sb);

            return;
        }

        int prev = -1;
        for (int i = 0; i < arr.length; i++) {

            if (prev == arr[i]) continue;
            temp[depth] = prev = arr[i];
            backtracking(depth + 1);
        }
    }
}
