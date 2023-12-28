package baekjoon.no11497;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] height = new int[n];
            for (int i = 0; i < n; i++) {
                height[i] = sc.nextInt();
            }

            Arrays.sort(height);

            int[] arr = new int[n];
            int left = 0;
            int right = n - 1;

            for (int i = 0; i < height.length; i++) {
                if (i % 2 == 0) {
                    arr[left++] = height[i];
                } else {
                    arr[right--] =height[i];
                }
            }

            int min = Math.abs(arr[n - 1] - arr[0]);

            for (int i = 1; i < arr.length; i++) {
                min = Math.max(min, Math.abs(arr[i] - arr[i - 1]));
            }

            System.out.println(min);
        }
    }
}
