package baekjoon.no18;

import java.util.Scanner;

// 2675 - 문자열 반복
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int R = sc.nextInt();
            String data = sc.next();

            for (int j = 0; j < data.length(); j++) {
                Character ch = data.charAt(j);

                for (int k = 0; k < R; k++) {
                    System.out.print(ch);
                }
            }
            System.out.println();
        }
    }
}
