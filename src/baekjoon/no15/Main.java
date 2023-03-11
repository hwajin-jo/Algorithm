package baekjoon.no15;

import java.util.Scanner;

// 8958 - OX퀴즈
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        int score = 0;
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            int cnt = 0;
            for (int j = 0; j < str.length(); j++) {

                if (str.charAt(j) == 'O') {
                    cnt++;
                } else {
                    cnt = 0;
                }
                score += cnt;
            }
            System.out.println(score);
            score = 0;
        }
    }
}
