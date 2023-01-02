package LCT.Greedy.no1;

import java.util.Arrays;
import java.util.Scanner;

// 큰 수의 법칙
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        int[] arr = new int[N];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int first = arr[N-1];
        int second = arr[N-2];

        int max_sum = 0;
        int cnt = 0;
        for (int i = 0; i < M; i++) {
            if (cnt < K) {
                max_sum += first;
                cnt++;
            } else if (cnt == K) {
                max_sum += second;
                cnt = 0;
            }

        }

        System.out.println(max_sum);
    }
}
