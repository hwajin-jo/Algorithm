package LCT.Greedy.no2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc. nextInt();
        int M = sc.nextInt();
        int[][] arr = new int[N][M];


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        ArrayList<Integer> minList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int min = Integer.MAX_VALUE;

            for (int j = 0; j < M; j++) {
                min = Math.min(min, arr[i][j]);
            }
            minList.add(min);
        }

        Collections.sort(minList);

        System.out.println(minList.get(N-1));
    }
}
