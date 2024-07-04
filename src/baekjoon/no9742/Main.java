package baekjoon.no9742;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static char[] data;
    static boolean[] visited;
    static List<String> list;
    static StringBuilder sb = new StringBuilder();
    static int target;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input;
        while ((input = br.readLine()) != null) {
            String[] arr = input.split(" ");
            data = arr[0].toCharArray();
            target = Integer.parseInt(arr[1]);

            visited = new boolean[data.length];
            list = new ArrayList<>();

            permutation(0);

            Collections.sort(list);
            if (list.size() < target) {
                bw.write(input + " = " + "No permutation\n");
            } else {
                bw.write(input + " = " + list.get(target - 1) + "\n");
            }
        }

        bw.flush();
        bw.close();
    }

    static void permutation(int depth) {
        if (list.size() >= target) {
            return;
        }

        if (depth == data.length) {
            list.add(sb.toString());
            return;
        }

        for (int i = 0; i < data.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sb.append(data[i]);
                permutation(depth + 1);
                sb.deleteCharAt(sb.length() - 1);
                visited[i] = false;
            }
        }
    }
}
