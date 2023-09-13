package baekjoon.no10025;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static class Bucket {
        int g;
        int x;

        public Bucket(int g, int x) {
            this.g = g;
            this.x = x;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();


        Bucket[] bucket = new Bucket[N];
        for (int i = 0; i < N; i++) {
            bucket[i] = new Bucket(sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(bucket, (o1, o2) -> o1.x - o2.x);

        int nextIndex = 0;
        int maxSum = 0;
        int currentSum = 0;

        for (int i = 0; i < N; i++) {
            while (nextIndex < N && bucket[nextIndex].x - bucket[i].x <= 2 * K) {
                currentSum += bucket[nextIndex++].g;
            }

            maxSum = Math.max(maxSum, currentSum);
            currentSum -= bucket[i].g;
        }


        System.out.println(maxSum);
    }
}
