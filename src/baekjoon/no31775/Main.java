package baekjoon.no31775;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] data = new char[3];
        for (int i = 0; i < 3; i++) {
            data[i] = sc.next().charAt(0);
        }

        int cnt = 0;
        boolean[] check = new boolean[3];
        for (int i = 0; i < 3; i++) {
            if (data[i] == 'k' && !check[0]) {
                check[0] = true;
                cnt++;
            } else if (data[i] == 'l' && !check[1]) {
                check[1] = true;
                cnt++;
            } else if (data[i] == 'p' && !check[2]) {
                check[2] = true;
                cnt++;
            }
        }

        if (cnt == 3) {
            System.out.println("GLOBAL");
        } else {
            System.out.println("PONIX");
        }
    }
}
