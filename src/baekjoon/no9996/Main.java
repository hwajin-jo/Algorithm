package baekjoon.no9996;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String[] pattern = sc.next().split("\\*");

        while (N-- > 0) {
            String data = sc.next();
            if (data.startsWith(pattern[0])) {
                data = data.substring(pattern.length);
                if (data.endsWith(pattern[1])) {
                    System.out.println("DA");
                } else {
                    System.out.println("NE");
                }
            } else {
                System.out.println("NE");
            }
        }
    }
}
