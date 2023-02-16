package LCT.DP.no4;

import java.util.Arrays;
import java.util.Scanner;

// 효율적인 화폐구성
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 앞서 계산된 결과를 저장하기 위한 DP 테이블 초기화
        int[] d = new int[m+1];
        Arrays.fill(d, 10001);

        // 다이나믹 프로그래밍(Dynamic Programming) 진행 (bottom-up)
        d[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = arr[i]; j <= m; j++) {
                d[j] = Math.min(d[j], d[j - arr[i]] +1);
            }
        }

        if (d[m] == 10001) System.out.println(-1);
        else System.out.println(d[m]);

    }
}
