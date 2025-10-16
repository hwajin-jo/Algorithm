package baekjoon.no1269;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<Integer> aSet = new HashSet<>();
        Set<Integer> bSet = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            aSet.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            bSet.add(Integer.parseInt(st.nextToken()));
        }

        Set<Integer> set = new HashSet<>();

        for (int a : aSet) {
            if (!bSet.contains(a))
                set.add(a);
        }


        for (int b : bSet) {
            if (!aSet.contains(b))
                set.add(b);
        }

        System.out.println(set.size());
    }
}
