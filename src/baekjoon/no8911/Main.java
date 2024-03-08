package baekjoon.no8911;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        int[] dr = {-1, 0, 1, 0}; // 북 동 남 서
        int[] dc = {0, 1, 0, -1};

        while (T-- > 0) {
            Point turtle = new Point(250, 250, 0);
            char[] cmd = sc.next().toCharArray();
            int minR = 250;
            int minC = 250;
            int maxR = 250;
            int maxC = 250;


            for (char c : cmd) {
                int nr = -1;
                int nc = -1;
                int dir = -1;
                switch (c) {
                    case 'F':
                        nr = turtle.r + dr[turtle.dir];
                        nc = turtle.c + dc[turtle.dir];
                        dir = turtle.dir;
                        break;
                    case 'B':
                        nr = turtle.r + dr[turtle.dir] * (-1);
                        nc = turtle.c + dc[turtle.dir] * (-1);
                        dir = turtle.dir;
                        break;
                    case 'L':
                        nr = turtle.r;
                        nc = turtle.c;
                        if (turtle.dir == 0) {
                            dir = 3;
                        } else {
                            dir = turtle.dir - 1;
                        }
                        break;

                    case 'R':
                        nr = turtle.r;
                        nc = turtle.c;
                        if (turtle.dir == 3) {
                            dir = 0;
                        } else {
                            dir = turtle.dir + 1;
                        }
                        break;

                }

                turtle.r = nr;
                turtle.c = nc;
                turtle.dir = dir;

                minR = Math.min(minR, nr);
                minC = Math.min(minC, nc);
                maxR = Math.max(maxR, nr);
                maxC = Math.max(maxC, nc);
            }

            int res = Math.abs(maxR - minR) * Math.abs(maxC - minC);
            System.out.println(res);
        }
    }
}

class Point {
    int r, c;
    int dir;

    public Point(int r, int c, int dir) {
        this.r = r;
        this.c = c;
        this.dir = dir;
    }
}
