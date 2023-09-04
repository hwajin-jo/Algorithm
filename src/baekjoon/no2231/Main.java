package baekjoon.no2231;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int ans = 0;
        for (int i = 0; i < n; i++) {
            String mStr = String.valueOf(i);

            int m = i;
            for (int j = 0; j < mStr.length(); j++) {
                int temp = mStr.charAt(j) - '0';

                m += temp;
            }

            if (m == n) {
                ans = i;
                break;
            }
        }

        System.out.println(ans);
    }
}
