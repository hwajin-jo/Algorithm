package baekjoon.no14888;

import java.util.Scanner;

public class Main {
    static int N;
    static int[] arr;
    static int[] operator;

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        arr = new int[N];
        operator = new int[4];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < 4; i++) {
            operator[i] = sc.nextInt();
        }

        dfs(1, arr[0]);

        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int depth, int sum) {
        if (depth == arr.length) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }

        for (int i = 0; i < operator.length; i++) {
            if (operator[i] > 0) {
                operator[i]--;
                switch (i) {
                    case 0:
                        dfs(depth + 1, sum + arr[depth]);
                        break;
                    case 1:
                        dfs(depth + 1, sum - arr[depth]);
                        break;
                    case 2:
                        dfs(depth + 1, sum * arr[depth]);
                        break;
                    case 3:
                        dfs(depth + 1, sum / arr[depth]);
                        break;
                }
                operator[i]++;
            }
        }
    }
}
