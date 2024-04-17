package baekjoon.no10833;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int ans = 0;

        while (n-- > 0) {
            int students = sc.nextInt();
            int apples = sc.nextInt();

            ans += apples % students;
        }

        System.out.println(ans);
    }
}
