package baekjoon.no21;

import java.util.Scanner;

// 11050 - 이항 계수 1
public class Main {

    static int[] dp = new int[10];

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int M = N - K;

        int num1 = Factorial(N);
        int num2 = Factorial(K);
        int num3 = Factorial(M);

        int result = num1 / (num2 * num3);
        System.out.println(result);
    }

    public static int Factorial(int num) {
        if (num == 0) return 1;

        return num * Factorial(num-1);
    }
}
