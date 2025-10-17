package baekjoon.no2851;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] mushroom = new int[10];

        for (int i = 0; i < mushroom.length; i++) {
            mushroom[i] = sc.nextInt();
        }

        int answer = -1;
        int diff = 100;
        int sum = 0;

        for (int i = 0; i < mushroom.length; i++) {
            sum += mushroom[i];

            if (Math.abs(100 - sum) <= diff) {
                diff = 100 - sum;
                answer = Math.max(answer, sum);
            }
        }

        System.out.println(answer);
    }
}
