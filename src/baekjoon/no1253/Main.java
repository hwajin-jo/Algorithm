package baekjoon.no1253;

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

        int goodNumber = 0;
        for (int i = 0; i < arr.length; i++) {
            int findNumber = arr[i];
            int s = 0;
            int e = arr.length - 1;

            int sum;

            while (s < e) {
                sum = arr[s] + arr[e];

                if (sum == findNumber) {
                    if (s == i) {
                        s++;
                    } else if (e == i) {
                        e--;
                    } else {
                        goodNumber++;
                        break;
                    }
                }

                if (sum > findNumber) {
                    e--;
                } else if (sum < findNumber) {
                    s++;
                }
            }
        }

        System.out.println(goodNumber);
    }
}
