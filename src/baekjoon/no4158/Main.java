package baekjoon.no4158;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if (n == 0 && m == 0) {
                break;
            }

            int[] arr = new int[n];
            int[] num = new int[m];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                num[i] = Integer.parseInt(st.nextToken());
            }

            int ans = 0;

            for (int i = 0; i < n; i++) {
                if (binarySeach(arr[i], num))
                    ans++;
            }

            System.out.println(ans);
        }
    }

    private static boolean binarySeach(int target, int[] num) {
        int start = 0;
        int end = num.length;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (num[mid] == target) {
                return true;
            } else if (num[mid] > target) {
                end = mid - 1;
            } else if (num[mid] < target) {
                start = mid + 1;
            }
        }

        return false;
    }
}
