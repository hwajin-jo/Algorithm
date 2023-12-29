package baekjoon.no2490;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] bars = {'E', 'A', 'B', 'C', 'D'}; // 모 도 개 걸 윷
        for (int i = 0; i < 3; i++) {
            int bae = 0;
            for (int j = 0; j < 4; j++) {
                int input = sc.nextInt();
                if (input == 0)
                    bae++;
            }

            System.out.println(bars[bae]);



        }
    }
}
