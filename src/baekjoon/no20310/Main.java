package baekjoon.no20310;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.next();

        int zero = 0;
        int one = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '0') zero++;
            else one++;
        }

        zero = zero / 2;
        one = one / 2;

        StringBuilder sb = new StringBuilder(input);

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '1' && one > 0) {
                sb.setCharAt(i, '2');
                one--;
            }
        }

        for (int i = input.length() - 1; i >= 0; i--) {
            if (input.charAt(i) == '0' && zero > 0) {
                sb.setCharAt(i, '2');
                zero--;
            }
        }

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '2') continue;
            System.out.print(sb.charAt(i));
        }

        System.out.println();

    }
}
