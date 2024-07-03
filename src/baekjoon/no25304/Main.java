package baekjoon.no25304;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int n = sc.nextInt();

        int total = 0;
        while (n-- > 0) {
            int price = sc.nextInt();
            int quantity = sc.nextInt();

            total += price * quantity;
        }

        if (total == x) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
