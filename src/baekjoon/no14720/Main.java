package baekjoon.no14720;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int total = 0;
        int milk = 0;
        for (int i = 0; i < n; i++) {
            if (milk == arr[i]) {
                total++;
                milk++;
            }

            if (milk == 3) {
                milk = 0;
            }
        }

        System.out.println(total);
    }
}
