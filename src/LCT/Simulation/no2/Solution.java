package LCT.Simulation.no2;

// 시각
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int cnt = 0;
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j < 60; j++) {
                for (int k = 0; k < 60; k++) {
                    String str1 = String.valueOf(i);
                    String str2 = String.valueOf(j);
                    String str3 = String.valueOf(k);

                    if (str1.contains("3") || str2.contains("3") || str3.contains("3")) {
                        cnt++;
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}
