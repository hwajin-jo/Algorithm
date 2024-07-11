package baekjoon.no1475;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String data = sc.next();

        int[] cnt = new int[10];

        for (int i = 0; i < data.length(); i++) {
            cnt[data.charAt(i) - '0']++;
        }

        int max = 1;
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] > 1) {
                if (i == 6 || i == 9) continue;
                max = Math.max(max, cnt[i]);
            }
        }

        int sum = cnt[6] + cnt[9];

        if (max > sum / 2 + sum % 2) {
            System.out.println(max);
        } else {
            System.out.println(sum / 2 + sum % 2);
        }
    }
}
