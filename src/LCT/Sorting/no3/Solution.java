package LCT.Sorting.no3;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// 두 배열의 원소 교체
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        Integer[] A = new Integer[n];
        Integer[] B = new Integer[n];

        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            B[i] = sc.nextInt();
        }

        Arrays.sort(A);
        Arrays.sort(B, Collections.reverseOrder());

        for (int i = 0; i < k; i++) {
            if (A[i] < B[i]) {
                int temp = A[i];
                A[i] = B[i];
                B[i] = temp;
            } else break;
        }

        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }

        System.out.println(sum);
    }
}
