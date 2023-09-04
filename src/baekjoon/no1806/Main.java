package baekjoon.no1806;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 0;
        int right = 0;
        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        while (left <= N &&right <= N) {
            if (sum >= S) {
                int diff = right - left;
                minLength = Math.min(diff, minLength);
                sum -= arr[left++];
            } else {
                sum += arr[++right];
            }
        }

        if (minLength == Integer.MAX_VALUE)
            System.out.println(0);
        else
            System.out.println(minLength);
    }
}

