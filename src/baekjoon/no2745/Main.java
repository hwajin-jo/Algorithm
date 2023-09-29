package baekjoon.no2745;


import java.util.Scanner;

// 진법 변환
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String N = sc.next();
        int B = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        sb = sb.append(N).reverse();
        int ans = 0;
        // B진법 N을 10진법으로 변환하는 로직
        for (int i = 0; i < sb.length(); i++) {
            int num = sb.charAt(i) - '0';

            if (num >= 17 && num <= 42) {
                num -= 7;
            }

            int exp = 1;
            for (int j = 0; j < i; j++) {
                exp *= B;
            }
            ans = ans + (num * exp);
        }

        System.out.println(ans);
    }
}
