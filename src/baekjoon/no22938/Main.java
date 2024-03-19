package baekjoon.no22938;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int r1 = sc.nextInt();

        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        int r2 = sc.nextInt();

        long res = ((long) (x1 - x2) * (x1 - x2)) + ((long) (y1 - y2) * (y1 - y2));
        long target = ((long) r1 + r2) * ((long) r1 + r2);

        if (res < target) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
