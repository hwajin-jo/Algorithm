package baekjoon.no13144;

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
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = n;
        Map<Integer, Integer> map = new HashMap<>();
        for (int s = 0; s < n; s++) {
            int e = s + 1;
            map.put(arr[s], map.getOrDefault(arr[s], 0) + 1);
            while (e < n) {
                if (arr[s] == arr[e]) break;
                map.put(arr[e], map.getOrDefault(arr[e], 0) + 1);
                if (map.get(arr[e]) > 1) break;
                map.put(arr[e], map.getOrDefault(arr[e], 0) + 1);
                ans++;
                e++;
            }
            map.put(arr[s], map.get(arr[s]) - 1);
        }

        System.out.println(ans);
    }
}
