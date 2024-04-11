package baekjoon.no14719;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int w = sc.nextInt();

        int[] height = new int[w];
        for (int i = 0; i < w; i++) {
            height[i] = sc.nextInt();
        }



        int total = 0;
        int idx = 1;
        while (idx < height.length) {
            int left = 0;
            int right = 0;
            for (int i = idx; i >= 0; i--) {
                if (height[i] > left) {
                    left = height[i];
                }
            }

            for (int i = idx; i < height.length; i++) {
                if (height[i] > right) {
                    right = height[i];
                }
            }
            if (left == 0 || right == 0) {
                idx++;
                continue;
            }

            int min = Math.min(left, right);
            total += min - height[idx];

            idx++;
        }

        System.out.println(total);
    }
}
