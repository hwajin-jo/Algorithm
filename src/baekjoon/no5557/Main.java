package baekjoon.no5557;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static int N;
    static int[] arr;
    static char[] op = {'+', '-'};
    static char[] temp;
    static long ans;
    static int res;
    static Set<String> set;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        arr = new int[N - 1];
        temp = new char[N - 2];
        set = new HashSet<>();
        for (int i = 0; i < N - 1; i++) {
            arr[i] = sc.nextInt();
        }
        res = sc.nextInt();
        ans = 0;
        solve(0);

        System.out.println(ans);
    }

    static void solve(int depth) {
        if (depth == N - 2) {
            if (isValid(res)) {
                ans++;
            }
            return;
        }

        for (char c : op) {
            temp[depth] = c;
            solve(depth + 1);
        }
    }

    static boolean isValid(int res) {
        int total = arr[0];
        StringBuilder sb = new StringBuilder();
        sb.append(arr[0]);
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == '+') {
                total += arr[i + 1];
                sb.append('+').append(arr[i + 1]);
            } else {
                total -= arr[i + 1];
                sb.append('-').append(arr[i + 1]);
            }

            if (total < 0 || total > 20) return false;
        }

        if (set.contains(sb.toString())) return false;
        set.add(sb.toString());

        return total == res;
    }
}
