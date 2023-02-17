package baekjoon.no11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 10815 - 숫자카드
public class Main {
    public static int[] arr;
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 숫자 카드 정렬
        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        // 숫자카드 탐색 시작
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            binarySearch(num);
        }
    }

    public static void binarySearch(int num) {
        int start = 0;
        int end = n - 1;
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;

            if (arr[mid] == num) {
                System.out.print(1 + " ");
                break;
            }
            if (arr[mid] > num) {
                end = mid - 1;
            } else if (arr[mid] < num) {
                start = mid + 1;
            }
        }

        if (start > end) {
            System.out.print(0 + " ");
        }
    }
}
