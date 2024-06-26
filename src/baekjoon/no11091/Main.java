package baekjoon.no11091;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int[] alphabet = new int[26];
            String input = br.readLine();
            input = input.replace(" ", "").toLowerCase();
            for (int i = 0; i < input.length(); i++) {
                int idx = input.charAt(i) - 'a';
                if (0 <= idx && idx < 26)
                    alphabet[idx]++;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < alphabet.length; i++) {
                if (alphabet[i] == 0)
                    sb.append((char) ('a' + i));
            }

            if (sb.length() == 0) {
                System.out.println("pangram");
            } else {
                System.out.println("missing " + sb);
            }
        }
    }
}
