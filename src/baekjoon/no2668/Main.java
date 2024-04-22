package baekjoon.no2668;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    static int[] arr;
    static boolean[] visited;
    static Set<Integer> tSet;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        arr = new int[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        tSet = new TreeSet<>();
        for (int i = 1; i <= n; i++) {
            HashSet<Integer> set = new HashSet<>();
            set.add(i);
            if (!tSet.contains(i))
                solve(i, arr[i], set);
        }

        System.out.println(tSet.size());

        for (int num : tSet) {
            System.out.println(num);
        }
    }

    static void solve(int origin, int cur, HashSet<Integer> set) {
        if (origin == cur) {
            tSet.addAll(set);
            return;
        }

        if (!visited[cur]) {
            visited[cur] = true;
            set.add(cur);
            solve(origin, arr[cur], set);
            visited[cur] = false;
        }
    }
}
