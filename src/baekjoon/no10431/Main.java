package baekjoon.no10431;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        int[] student = new int[20];
        for (int i = 0; i < T; i++) {
            int idx = sc.nextInt();
            for (int j = 0; j < 20; j++) {
                student[j] = sc.nextInt();
            }

            int cnt = 0;
            for (int j = 0; j < student.length - 1; j++) {
                for (int k = j + 1; k < student.length; k++) {
                    if (student[j] > student[k]) {
                        int temp = student[j];
                        student[j] = student[k];
                        student[k] = temp;

                        cnt++;
                    }
                }
            }

            System.out.println(idx + " " + cnt);
        }
    }

}
