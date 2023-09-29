package baekjoon.no1223;

import java.util.Scanner;

// 주사위
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s1 = sc.nextInt();
        int s2 = sc.nextInt();
        int s3 = sc.nextInt();

        int[] arr1 = new int[s1];
        int[] arr2 = new int[s2];
        int[] arr3 = new int[s3];

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = i + 1;
        }

        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = i + 1;
        }

        for (int i = 0; i < arr3.length; i++) {
            arr3[i] = i + 1;
        }

        int[] cnt = new int[80];

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                for (int k = 0; k < arr3.length; k++) {
                    int sum = arr1[i] + arr2[j] + arr3[k];
                    cnt[sum]++;
                }
            }
        }

        int max = 0;
        for (int i = 3; i < cnt.length; i++) {
            max = Math.max(max, cnt[i]);
        }

        for (int i = 3; i < cnt.length; i++) {
            if (cnt[i] == max) {
                System.out.println(i);
                break;
            }
        }
    }
}
