package baekjoon.no2908;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringBuilder a = new StringBuilder(sc.next());
        StringBuilder b = new StringBuilder(sc.next());

        int conA = Integer.parseInt(a.reverse().toString());
        int conB = Integer.parseInt(b.reverse().toString());

        if (conA > conB)
            System.out.println(conA);
        else
            System.out.println(conB);
    }
}
