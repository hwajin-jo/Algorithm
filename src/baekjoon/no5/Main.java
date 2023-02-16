package baekjoon.no5;

import java.util.Scanner;

// 1259 - 팰린드롬수
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        while (true) {
            int n  = sc.nextInt();
            if (n == 0) {
                break;
            } else {
                String str = Integer.toString(n);
                int cnt = 0;
                for (int i = 0; i < str.length() / 2; i++) {
                    if (str.charAt(i) == str.charAt(str.length() - i - 1)) cnt++;
                }

                if (cnt == str.length()/2) System.out.println("yes");
                else System.out.println("no");
            }
        }
        sc.close();
    }
}
