package LCT.Binary_Search.no2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

// 이진탐색 - HashSet 이용
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        HashSet<Integer> hashSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            hashSet.add(sc.nextInt());
        }



        int m = sc.nextInt();
        int[] arr_2 = new int[m];

        for (int i = 0; i < m; i++) {
            arr_2[i] = sc.nextInt();
        }
        
        for (int i = 0; i < m; i++) {
            if (hashSet.contains(arr_2[i])) {
                System.out.print("yes ");
            } else {
                System.out.print("no ");
            }
        }
    }
}
