package baekjoon.no15565;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] dolls = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            dolls[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;

        int cnt;
        if (dolls[start] == 1)
            cnt = 1;
        else
            cnt = 0;

        int minStart = 0;
        int minEnd = Integer.MAX_VALUE;
        while (end < n) {
            if (cnt >= k) {
                if (cnt == k) {
                    if (minEnd - minStart > end - start) {
                        minStart = start;
                        minEnd = end;
                    }
                }
                if (start < n && dolls[start] == 1)
                    cnt--;
                start++;
            } else {
                end++;
                if (end < n && dolls[end] == 1)
                    cnt++;
            }


        }

        if (cnt == 0)
            System.out.println(-1);
        else
            System.out.println(minEnd - minStart + 1);
    }
}
