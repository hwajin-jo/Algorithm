package baekjoon.no10867;

import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        TreeSet<Integer> treeSet = new TreeSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            treeSet.add(Integer.parseInt(st.nextToken()));
        }

        for (int num : treeSet) {
            bw.write(num + " ");
        }

        bw.flush();
        bw.close();
    }
}
