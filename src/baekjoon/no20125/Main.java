package baekjoon.no20125;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        char[][] maps = new char[n][n];

        boolean flag = false;
        Point head = null;
        for (int i = 0; i < n; i++) {
            maps[i] = sc.next().toCharArray();
            for (int j = 0; j < maps[i].length; j++) {
                if (!flag && maps[i][j] == '*') {
                    head = new Point(i, j);
                    flag = true;
                }
            }
        }

        int r;
        int c;

        Point heart = new Point(head.r + 1, head.c);
        int left_arm = 0;
        c = heart.c - 1;
        while (maps[heart.r][c] != '_') {
            left_arm++;
            c--;
            if (c < 0 || c >= n) break;
        }
        int right_arm = 0;
        c = heart.c + 1;

        while (maps[heart.r][c] != '_') {
            right_arm++;
            c++;
            if (c >= n) break;
        }
        int waist = 0;
        r = heart.r + 1;
        while (maps[r][heart.c] != '_') {
            waist++;
            r++;
        }

        Point lastWaist = new Point(r, heart.c);
        int left_leg = 0;

        r = lastWaist.r;
        c = lastWaist.c - 1;
        while (maps[r][c] != '_') {
            left_leg++;
            r++;

            if (r >= n || c >= n) break;
        }

        int right_leg = 0;
        r = lastWaist.r;
        c = lastWaist.c + 1;

        while (maps[r][c] != '_') {
            right_leg++;
            r++;
            if (r >= n || c >= n) break;
        }

        System.out.println((heart.r + 1) + " " + (heart.c + 1));
        System.out.println(left_arm + " " + right_arm + " " + waist + " " + left_leg + " " + right_leg);
    }
}

class Point {
    int r, c;

    public Point (int r, int c) {
        this.r = r;
        this.c = c;
    }
}
