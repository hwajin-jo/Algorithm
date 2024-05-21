package baekjoon.no2577;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        String res = String.valueOf(a * b * c);

        int[] cnt = new int[10];
        for (int i = 0; i < res.length(); i++) {
            cnt[res.charAt(i) - '0']++;
        }

        for (int i = 0; i < cnt.length; i++) {
            System.out.println(cnt[i]);
        }
    }
}
