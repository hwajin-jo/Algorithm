package baekjoon.no2960;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        int cnt = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                cnt++;

                if (cnt == k) {
                    System.out.println(i);
                    System.exit(0);
                }

                for (int j = i + i; j <= n; j+= i) {
                    if (isPrime[j]) {
                        isPrime[j] = false;
                        cnt++;
                    }

                    if (cnt == k) {
                        System.out.println(j);
                        System.exit(0);
                    }
                }
            }
        }
    }
}
