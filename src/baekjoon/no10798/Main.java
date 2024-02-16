package baekjoon.no10798;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[][] word = new char[5][15];

        int max = 0;
        for (int i = 0; i < 5; i++) {
            String input = sc.next();
            max = Math.max(max, input.length());
            for (int j = 0; j < input.length(); j++) {
                word[i][j] = input.charAt(j);
            }
        }

        for (int i = 0; i < max; i++) {
            for (int j = 0; j < 5; j++) {
                if (word[j][i] == '\0') continue;
                System.out.print(word[j][i]);
            }
        }

        System.out.println();
    }
}
