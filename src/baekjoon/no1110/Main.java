package baekjoon.no1110;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int cnt = 0;
        int m = 0;
        int temp = n;
        while (true) {
            int result = temp / 10;
            int remain = temp % 10;

            m = remain * 10 + (result + remain) % 10;
            cnt++;

            if (n == m)
                break;

            temp = m;

        }

        System.out.println(cnt);
    }
}
