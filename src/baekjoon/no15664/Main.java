package baekjoon.no15664;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int n, m;
    static int[] arr;
    static int[] temp;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        temp = new int[m];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        solve(0, 0);
    }

    static void solve (int depth, int start) {
        if (depth == m) {
            StringBuilder sb = new StringBuilder();
            for (int j : temp) {
                sb.append(j).append(" ");
            }

            System.out.println(sb);
            return;
        }

        int prev = 0;
        for (int i = start; i < n; i++) {
            if (!visited[i] && prev != arr[i]) {
                visited[i] = true;
                temp[depth] = arr[i];
                prev = temp[depth];
                solve(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }
}
