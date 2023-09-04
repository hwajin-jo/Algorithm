package baekjoon.no24;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] basket = new int[N];

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            basket[i-1] = i;
        }

        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            --start;
            --end;
            while (start <= end) {
                int tmp = basket[start];
                basket[start] = basket[end];
                basket[end] = tmp;

                start++;
                end--;
            }
        }

        for (int i = 0; i < basket.length; i++) {
            System.out.print(basket[i] + " ");
        }
        System.out.println();
    }
}
