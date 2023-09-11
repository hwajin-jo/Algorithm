package baekjoon.no15831;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int B = sc.nextInt();
        int W = sc.nextInt();
        String input = sc.next();

        char[] chars = input.toCharArray();

        int countB = 0;
        int countW = 0;

        int ans = 0;

        int idx = 0;
        for (int i = 0; i < N; ) {
            if (countB <= B && countW >= W) {
                int len = i - idx;
                ans = Math.max(ans, len);
            } if (countB > B) {
                if (chars[idx] == 'B') countB--;
                else countW--;
                idx++;
            } else {
                if (chars[i++] == 'B') countB++;
                else countW++;
            }
        }
        System.out.println(ans);
    }
}
