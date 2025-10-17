package baekjoon.no27433;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();

        System.out.println(factorial(N));
    }

    private static long factorial(long N) {
        if (N == 0 || N == 1)
            return 1;

        return factorial(N - 1) * N;
    }
}
