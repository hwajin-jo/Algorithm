package baekjoon.no5073;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[3];
        while (true) {
            arr[0] = sc.nextInt();
            arr[1] = sc.nextInt();
            arr[2] = sc.nextInt();

            if (isZero(arr[0], arr[1], arr[2])) break;

            Arrays.sort(arr);
            String res = check(arr[0], arr[1], arr[2]);
            System.out.println(res);
        }
    }

    static String check(int a, int b, int c) {
        if (a + b <= c) return "Invalid";
        if (a == b && b == c) return "Equilateral";
        if (a == b || b == c) return "Isosceles";
        else return "Scalene";
    }

    static boolean isZero(int a, int b, int c) {
        return a == 0 && b == 0 && c == 0;
    }
}
