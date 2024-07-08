package baekjoon.no4358;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String, Integer> map = new TreeMap<>();
        String input;
        int size = 0;
        while (true) {
            input = br.readLine();
            if (input == null || input.equals("")) break;

            map.put(input, map.getOrDefault(input, 0) + 1);
            size++;
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            bw.write(entry.getKey() + " "  + String.format("%.4f", (double) entry.getValue() / size * 100) + "\n");
        }

        bw.flush();
        bw.close();

    }
}
