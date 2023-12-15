package baekjoon.no2003;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int start = 0;
        int end = 0;

        int sum = arr[start];
        int cnt = 0;
        while (end < n) {
            if (sum >= m) {
                if (sum == m) cnt++;
                sum -= arr[start++];

            } else {
                end++;
                if (end < n)
                    sum += arr[end];
            }
        }

        System.out.println(cnt);
    }
}
