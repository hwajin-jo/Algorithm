package baekjoon.no26168;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new long[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());

            int type = Integer.parseInt(st.nextToken());

            if (type == 1) { // k보다 크거나 같은 원소의 개수
                long k = Long.parseLong(st.nextToken());
                int idx = lowerBound(k);
                bw.write(n - idx - 1 + "\n");
            } else if (type == 2) { // k보다 큰 원소의 개수
                long k = Long.parseLong(st.nextToken());
                int idx = upperBound(k);
                bw.write(n - idx + "\n");
            } else if (type == 3) { // i보다 크거나 같고 j보다 작거나 같은 원소의 개수
                long i = Long.parseLong(st.nextToken());
                long j = Long.parseLong(st.nextToken());
                int idx = lowerBound(i);
                int jdx = upperBound(j);
                bw.write(jdx - idx - 1 + "\n");
            }
        }

        bw.flush();
        bw.close();
    }

    static int upperBound(long target) {
        int left = 0;
        int right = arr.length - 1;

        int ans = arr.length;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (target < arr[mid]) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    static int lowerBound(long target) {
        int left = 0;
        int right = arr.length - 1;

        int ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (target > arr[mid]) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }
}
