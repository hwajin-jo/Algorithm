package baekjoon.no14931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int L = Integer.parseInt(st.nextToken());
        int[] river = new int[L + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= L; i++) {
            river[i] = Integer.parseInt(st.nextToken());
        }

        int maxD = 0;
        long sum = 0;
        for (int i = 1; i <= L; i++) {
            long tempSum = 0;
            for (int j = i; j <= L; j+=i) {
                tempSum += river[j];
            }
            if (sum < tempSum) {
                maxD = i;
                sum = tempSum;
            }
        }

        if (sum <= 0)
            System.out.println(0 + " " + 0);
        else
            System.out.println(maxD + " " + sum);
    }
}
