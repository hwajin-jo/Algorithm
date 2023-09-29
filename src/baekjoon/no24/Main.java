package baekjoon.no24;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        input = input.toUpperCase();

        int[] count = new int[26];

        for (int i = 0; i < input.length(); i++) {
           count[input.charAt(i) - 'A']++;
        }

        int max = 0;
        for (int i = 0; i < count.length; i++) {
            max = Math.max(count[i], max);
        }

        int cnt = 0;
        int max_index = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] == max) {
                cnt++;
                max_index = i;
            }
        }

        if (cnt == 1) {
            System.out.println((char) (max_index + 'A'));
        } else {
            System.out.println("?");
        }
    }
}
