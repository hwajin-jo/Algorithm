package baekjoon.no4779;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s;

        while ((s = br.readLine()) != null) {
            int n = Integer.parseInt(s);

            int len = (int) Math.pow(3, n);

            sb = new StringBuilder();
            for (int i = 0; i < len; i++) {
                sb.append("-");
            }

            recursive(0, len);

            System.out.println(sb);
        }
    }

    static private void recursive(int start, int size) {
        if (size < 1)
            return;

        int len = size / 3;
        for (int i = start + len; i < start + len * 2; i++) {
            sb.setCharAt(i, ' ');
        }

        recursive(start, len);
        recursive(start + len * 2, len);
    }
}
