package baekjoon.no20922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = 0;

        Map<Integer, Integer> map = new HashMap<>();

        int max = -1;
        boolean flag = true;
        while (end < n) {
            int key = arr[end];

            if (flag)
                map.put(key, map.getOrDefault(key, 0) + 1);

            if (map.get(key) <= k) {
                end++;
                flag = true;
            } else {
                key = arr[start++];
                map.put(key, map.get(key) - 1);
                flag = false;
            }

            max = Math.max(max, end - start);
        }

        System.out.println(max);
    }
}
