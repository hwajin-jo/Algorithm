package baekjoon.no2138;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        StringBuilder data1 = new StringBuilder(sc.next());
        StringBuilder data2 = new StringBuilder(data1);
        StringBuilder target = new StringBuilder(sc.next());

        data1.setCharAt(0, data1.charAt(0) == '1' ? '0' : '1');
        data1.setCharAt(1, data1.charAt(1) == '1' ? '0' : '1');

        int cnt1 = 1;
        int cnt2 = 0;

        for (int i = 1; i < n; i++) {
            if (data1.charAt(i - 1) != target.charAt(i - 1)) {
                if (i == n - 1) {
                    data1.setCharAt(i - 1, data1.charAt(i - 1) == '1' ? '0' : '1');
                    data1.setCharAt(i, data1.charAt(i) == '1' ? '0' : '1');
                } else {
                    data1.setCharAt(i - 1, data1.charAt(i - 1) == '1' ? '0' : '1');
                    data1.setCharAt(i, data1.charAt(i) == '1' ? '0' : '1');
                    data1.setCharAt(i + 1, data1.charAt(i + 1) == '1' ? '0' : '1');
                }

                cnt1++;
            }

            if (data2.charAt(i - 1) != target.charAt(i - 1)) {
                if (i == n - 1) {
                    data2.setCharAt(i - 1, data2.charAt(i - 1) == '1' ? '0' : '1');
                    data2.setCharAt(i, data2.charAt(i) == '1' ? '0' : '1');
                } else {
                    data2.setCharAt(i - 1, data2.charAt(i - 1) == '1' ? '0' : '1');
                    data2.setCharAt(i, data2.charAt(i) == '1' ? '0' : '1');
                    data2.setCharAt(i + 1, data2.charAt(i + 1) == '1' ? '0' : '1');
                }

                cnt2++;
            }
        }

        if (!data1.toString().equals(target.toString())) {
            cnt1 = Integer.MAX_VALUE;
        }

        if (!data2.toString().equals(target.toString())) {
            cnt2 = Integer.MAX_VALUE;
        }

        int ans = Math.min(cnt1, cnt2);

        if (ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }
}
