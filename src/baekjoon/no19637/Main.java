package baekjoon.no19637;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<Integer, String> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String type = st.nextToken();
            int power = Integer.parseInt(st.nextToken());
            if (!map.containsKey(power)) {
                map.put(power, type);
                list.add(power);
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int key = Integer.parseInt(st.nextToken());
            int res = binarySearch(key, list);
            bw.write(map.get(list.get(res)) + "\n");
        }

        bw.flush();
        bw.close();
    }

    static int binarySearch(int target, List<Integer> list) {
        int s = 0;
        int e = list.size() - 1;

        int ans = 0;
        while (s <= e) {
            int mid = (s + e) / 2;

            if (target <= list.get(mid)) {
                e = mid - 1;
                ans = mid;
            } else {
                s = mid + 1;
            }
        }

        return ans;
    }
}
