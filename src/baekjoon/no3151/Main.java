package baekjoon.no3151;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        long ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = arr[i] + arr[j];

                int lower = lowerBound(-sum, j + 1, n);
                int upper = upperBound(-sum, j + 1, n);

                ans += (upper - lower);
            }
        }

        System.out.println(ans);
    }

    private static int lowerBound(int target, int start, int end) {
        while (start < end) {
            int mid = (start + end) / 2;

            if (arr[mid] >= target) end = mid;
            else start = mid + 1;
        }

        return end;
    }

    private static int upperBound(int target, int start, int end) {
        while (start < end) {
            int mid = (start + end) / 2;

            if (arr[mid] > target) end = mid;
            else start = mid + 1;
        }

        return end;
    }
}

