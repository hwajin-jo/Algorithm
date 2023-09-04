package baekjoon.no2295;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] sum = new int[n * (n + 1) / 2];

        int sumIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                sum[sumIndex++] = arr[i] + arr[j];
            }
        }

        Arrays.sort(sum);

        int ans = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int result = arr[i] - arr[j];

                if (isExist(sum, result)) {
                    ans = Math.max(arr[i], ans);
                }
            }
        }

        System.out.println(ans);
    }

    public static boolean isExist(int[] arr, int result) {
        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {
            int m = (l + r) / 2;

            if (arr[m] > result) {
                r = m - 1;
            } else if (arr[m] < result) {
                l = m + 1;
            } else {
                return true;
            }
        }

        return false;
    }

}