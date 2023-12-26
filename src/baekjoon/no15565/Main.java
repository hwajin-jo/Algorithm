package baekjoon.no15565;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] dolls = new int[n];
        List<Integer> lion = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            dolls[i] = Integer.parseInt(st.nextToken());
            if (dolls[i] == 1)
                lion.add(i);
        }

        if (lion.size() < k) {
            System.out.println(-1);
            return;
        }

        int start = 0;
        int end = k - 1;
        int cnt = 0;
        int min = Integer.MAX_VALUE;
        while (end < lion.size()) {
            cnt = lion.get(end) - lion.get(start) + 1;
            min = Math.min(min, cnt);

            start++;
            end++;
        }

        System.out.println(min);
    }
}
