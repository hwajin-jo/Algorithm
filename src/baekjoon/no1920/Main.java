package baekjoon.no1920;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int m = sc.nextInt();

        for (int i = 0; i < m; i++) {
            int data = sc.nextInt();

            if (isExist(arr, data))
                System.out.println(1);
            else
                System.out.println(0);
        }
    }

    public static boolean isExist(int[] arr, int data) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == data) {
                return true;
            } else if (arr[mid] < data) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}
