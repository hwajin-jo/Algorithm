package baekjoon.no13423;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        while (T--> 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            cnt = 0;
            Arrays.sort(arr);
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    binarySearch(i, j, arr);
                }
            }

            System.out.println(cnt);
        }
    }

    private static void binarySearch(int i, int j, int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] - arr[j] == arr[j] - arr[i]) {
                cnt++;
                return;
            } else if (arr[mid] - arr[j] < arr[j] - arr[i]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
    }
}
