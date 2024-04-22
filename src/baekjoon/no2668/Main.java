package baekjoon.no2668;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    static Set<Integer> set;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        Set<Integer> set = new TreeSet<>();
        for (int i = 1; i <= n; i++) {
           if (isCycle(arr, i)) {
               int next = arr[i];
               while (next != i) {
                   set.add(next);
                   next = arr[next];
               }
               set.add(i);
           }
        }

        System.out.println(set.size());

        for (int num : set) {
            System.out.println(num);
        }
    }

    static boolean isCycle(int[] arr, int origin) {
        int cnt = 0;
        int next = arr[origin];
        while (cnt <= arr.length) {
            cnt++;
            if (next == origin) return true;
            next = arr[next];
        }

        return false;
    }
}
