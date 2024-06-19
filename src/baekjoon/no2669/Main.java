package baekjoon.no2669;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean[][] visited = new boolean[101][101];

        int T = 4;

        while (T-- > 0) {
            int startR = sc.nextInt();
            int startC = sc.nextInt();
            int endR = sc.nextInt();
            int endC = sc.nextInt();

            for (int i = startR; i < endR; i++) {
                for (int j = startC; j < endC; j++) {
                    visited[i][j] =  true;
                }
            }
        }

        int ans = 0;
        for (int i = 1; i < visited.length; i++) {
            for (int j = 1; j < visited[i].length; j++) {
                if (visited[i][j]) ans++;
            }
        }

        System.out.println(ans);
    }
}
