package baekjoon.no6;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        int cnt = 0;
        for (int i = 0; i < str.length()/2; i++) {
            if (str.charAt(i) == str.charAt(str.length() - i - 1)) cnt++;
        }

        if (cnt == str.length()/2) System.out.println(1);
        else System.out.println(1);
    }
}
