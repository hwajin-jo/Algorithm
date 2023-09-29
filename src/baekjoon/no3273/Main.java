package baekjoon.no3273;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int x = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        int ans = 0;

        int start = 0;
        int end = arr.length -1;

        while (start < end) {
            int sum = arr[start] + arr[end];

            if (sum == x) {
                ans++;
                start++;
                end--;
            } else if (sum > x) {
                end--;
            } else {
                start++;
            }

        }

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }
}
