package baekjoon.no14910;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(" ");

        boolean flag = true;
        int prev = Integer.parseInt(input[0]);
        for (int i = 1; i < input.length; i++) {
            if (Integer.parseInt(input[i]) >= prev) {
                prev = Integer.parseInt(input[i]);
            } else {
                flag = false;
                break;
            }
        }

        if (flag) {
            System.out.println("Good");
        } else {
            System.out.println("Bad");
        }
    }
}
