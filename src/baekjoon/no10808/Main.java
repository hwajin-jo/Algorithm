package baekjoon.no10808;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        int[] cnt = new int[26];

        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }

        for (int j : cnt) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
}
