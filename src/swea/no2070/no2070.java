package swea.no2070;

import java.util.Scanner;

public class no2070 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 1; i <= t; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            System.out.print("#" + i);
            if (a > b) {
                System.out.println(" >");
            } else if (a == b) {
                System.out.println(" =");
            } else {
                System.out.println(" <");
            }
        }
    }
}
