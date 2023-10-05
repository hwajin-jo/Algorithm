package baekjoon.no1941;

import java.util.Scanner;

public class Main {

    static char[][] school;
    static boolean[][] visited;
    static int[] result;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        school = new char[5][5];
        visited = new boolean[5][5];
        result = new int[7];

        for (int i = 0; i < 5; i++) {
            char[] input = sc.next().toCharArray();
            for (int j = 0; j < 5; j++) {
                school[i][j] = input[j];
            }
        }

        
    }
}
