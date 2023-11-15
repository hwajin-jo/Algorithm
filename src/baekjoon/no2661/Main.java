package baekjoon.no2661;

import java.util.Scanner;

public class Main {

    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        solve("");
    }

    static void solve(String str) {
        // base_case
        if (str.length() == N) {
            System.out.println(str);
            System.exit(0);
        }

        // recursive_case
        for (int i = 1; i <= 3; i++) {
            if (!isBad(str + i)) {
                solve(str + i);
            }
        }
    }

    static boolean isBad(String str) {

        for (int i = 1; i <= str.length() / 2; i++) {
            String front = str.substring(str.length() - i * 2, str.length() - i);
            String back = str.substring(str.length() - i);

            if (front.equals(back)) return true;
        }

        return false;
    }

}
