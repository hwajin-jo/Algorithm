package baekjoon.no1822;

import java.io.*;
import java.util.*;

public class Main {

    static int bSize;
    static int[] b;

     public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int aSize = Integer.parseInt(st.nextToken());
        bSize = Integer.parseInt(st.nextToken());

        int[] a = new int[aSize];
        b = new int[bSize];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < aSize; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < bSize; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

         Arrays.sort(b);

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < aSize; i++) {
            if (!binarySearch(a[i])) {
                list.add(a[i]);
            }
        }

         Collections.sort(list);
        if (list.isEmpty()) {
            bw.write(0 + "\n");
        } else {
            bw.write(list.size() + "\n");
            for (int num : list) {
                bw.write(num + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

    static boolean binarySearch(int target) {
         int start = 0;
         int end = bSize - 1;

         while (start <= end) {
             int mid = (start + end) / 2;

             if (b[mid] == target) {
                 return true;
             } else if (b[mid] > target) {
                 end = mid - 1;
             } else {
                 start = mid + 1;
             }
         }

         return false;
    }
}
