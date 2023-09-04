package baekjoon.no1120;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String A = sc.next();
        String B = sc.next();

        int cnt = 0;

        char[] arrA = A.toCharArray();
        char[] arrB = B.toCharArray();

        int diff = B.length() - A.length();

        int ans = Integer.MAX_VALUE;

        while (diff >= 0) {
            cnt = 0;
            for (int i = 0; i < A.length(); i++) {
                if (arrA[i] != arrB[i+diff]) cnt++;
            }

            ans = Math.min(ans, cnt);
            diff--;
        }


        System.out.println(ans);

    }
}
