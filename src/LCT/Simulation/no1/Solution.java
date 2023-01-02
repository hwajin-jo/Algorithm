package LCT.Simulation.no1;

import java.util.Scanner;

// 상하좌우
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // N 입력
        sc.nextLine(); // 버퍼비우기
        String[] plans = sc.nextLine().split(" ");
        char[] moveType = { 'L', 'R', 'U', 'D' };
        int[] dx = { 0, 0, -1, 1 };
        int[] dy = { -1, 1, 0, 0 };

        int x = 1;
        int y = 1;
        for (int i = 0; i < plans.length; i++) {
            char plan = plans[i].charAt(0);

            int nx = -1;
            int ny = -1;
            for (int j = 0; j < 4; j++) {
                if (plan == moveType[j]) {
                    nx = x + dx[j];
                    ny = y + dy[j];
                }
            }

            if (nx < 1 || ny < 1 || nx > N || ny > N) continue;

            x = nx;
            y = ny;
        }

        System.out.println(x + " " + y);
    }
}
