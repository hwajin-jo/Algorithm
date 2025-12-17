package baekjoon.no2902;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] data = sc.next().split("-");

        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i].charAt(0));
        }
        System.out.println();
    }
}
