package LCT.Binary_Search.no3;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];

        int max = -1;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            max = Math.max(max, arr[i]);
        }

        int start = 0;
        int end = max;

        int answer = 0;
        while (start <= end) {
            int mid = (start + end) / 2;

            long sum = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] > mid) {
                    sum += arr[i] - mid;
                }
            }

            if (sum < m) {
                end = mid - 1;
            } else {
                answer = mid;
                start = mid + 1;
            }

        }

        System.out.println(answer);
    }
}
