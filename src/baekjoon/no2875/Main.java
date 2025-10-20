package baekjoon.no2875;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 여학생 수
        int M = sc.nextInt(); // 남학생 수
        int K = sc.nextInt(); // 인턴 수

        int max = 0;
        for (int i = 0; i <= K; i++) {
            int tempN = N - i;
            int tempB = M - (K - i);

            int team = 0;
            while (tempN >= 0 && tempB >= 0) {
                tempB -= 1;
                tempN -= 2;

                if (tempN >= 0 && tempB >= 0)
                    team++;
            }

            max = Math.max(max, team);
        }

        System.out.println(max);
    }
}
