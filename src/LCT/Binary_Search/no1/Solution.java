package LCT.Binary_Search.no1;

import java.util.Arrays;
import java.util.Scanner;

// 부품 찾기 - 이진 탐색 이용
public class Solution {

    public static int binary_search(int start, int end, int target, int[] arr) {

        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                return 1;
            } else if(arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr_1 = new int[n];

        for (int i = 0; i < n; i++) {
            arr_1[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] arr_2 = new int[m];

        for (int i = 0; i < m; i++) {
            arr_2[i] = sc.nextInt();
        }

        Arrays.sort(arr_1);

        int start = 0;
        int end = arr_1.length-1;

        for (int i = 0; i < m; i++) {
            int result = binary_search(start, end, arr_2[i], arr_1);
            if (result != -1) {
                System.out.print("yes ");
            } else {
                System.out.print("no ");
            }
        }
    }


}
