package baekjoon.no10798;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[][] word = new char[5][];

        for (int i = 0; i < 5; i++) {
            String input = sc.next();
            word[i] = new char[input.length()];
            for (int j = 0; j < input.length(); j++) {
                word[i][j] = input.charAt(j);
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < word[i].length; j++) {
                System.out.print(word[j][i]);
            }
        }

        System.out.println();
    }
}
