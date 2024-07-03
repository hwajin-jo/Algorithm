package autoever2024.no1;

import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int[] cnt = new int[n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            int sIdx = lowerBound(s);
            int eIdx = upperBound(e);

            for (int j = sIdx; j < eIdx; j++) {
                cnt[j]++;
            }
        }

        List<Item> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Item(arr[i], cnt[i]));
        }

        Collections.sort(list, (o1, o2) -> {
            if (o1.cnt == o2.cnt) {
                return o1.idx - o2.idx;
            }

            return o2.cnt - o1.cnt;
        });

        bw.write(list.get(k).idx + "\n");

        bw.flush();
        bw.close();
    }

    static int upperBound(int target) {
        int s = 0;
        int e = arr.length - 1;

        while (s <= e) {
            int mid = (s + e) / 2;

            if (target < arr[mid]) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }

        return e + 1;
    }

    static int lowerBound(int target) {
        int s = 0;
        int e = arr.length - 1;

        while (s <= e) {
            int mid = (s + e) / 2;

            if (target > arr[mid]) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }

        return s;
    }
}

class Item {
    int idx;
    int cnt;

    public Item(int idx, int cnt) {
        this.idx = idx;
        this.cnt = cnt;
    }
}
