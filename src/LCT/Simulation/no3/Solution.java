package LCT.Simulation.no3;

import java.util.Scanner;

// 왕실의 나이트
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        int[] dx = {-2, -2, 2, 2, 1, -1, 1, -1};
        int[] dy = {-1, 1, 1, -1, -2, -2, 2, 2};
        int x = str.charAt(0) - 96;
        int y = str.charAt(1) - '0';

        int cnt = 0;
        for (int i = 0; i < 8; i++) {

            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 1 || ny < 1 || nx > 8 || ny > 8) continue;

            cnt++;

        }

        System.out.println(cnt);
    }
}
