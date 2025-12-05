package baekjoon.no2566;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] arr =  new int[9][9];

        int max = -1;
        int maxR = -1;
        int maxC = -1;

        for (int i = 0; i < 9; i++) {
            String[] data = br.readLine().split(" ");
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(data[j]);

                if (max < arr[i][j]) {
                    max = arr[i][j];
                    maxR = i + 1;
                    maxC = j + 1;
                }
            }
        }

        System.out.println(max);
        System.out.println(maxR + " " + maxC);
    }
}
