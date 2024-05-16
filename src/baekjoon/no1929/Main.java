package baekjoon.no1929;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        boolean[] isPrime = new boolean[b + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1]= false;

        for (int i = 2; i <= b; i++) {
            if (isPrime[i]) {
                for (int j = i + i; j <= b; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = a; i <= b; i++) {
            if (isPrime[i]) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);

    }
}
