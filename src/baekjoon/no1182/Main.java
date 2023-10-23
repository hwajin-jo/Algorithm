package baekjoon.no1182;

import java.util.Scanner;

public class Main {

    static int N, S;
    static int[] arr;
    static int ans = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        S = sc.nextInt();

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        solve(0, 0);

        System.out.println(ans);
    }

    static void solve(int index, int sum) {
        if (index == arr.length) return;
        if (sum + arr[index] == S) ans++;

        solve(index + 1, sum + arr[index]);
        solve(index + 1, sum);
    }
}
