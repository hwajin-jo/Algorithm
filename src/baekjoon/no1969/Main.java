package baekjoon.no1969;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        List<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {

            int[] alphabet = new int[26];
            for (String s : list) {
                alphabet[s.charAt(i) - 'A']++;
            }

            int max = 0;
            int maxIdx = 0;
            for (int j = 0; j < alphabet.length; j++) {
                if (alphabet[j] > max) {
                    max = alphabet[j];



                    maxIdx = j;
                }
            }

            sb.append((char) ('A' + maxIdx));
        }

        int sum = 0;
        String target = sb.toString();

        for (String dna : list) {
            for (int i = 0; i < dna.length(); i++) {
                if (dna.charAt(i) != target.charAt(i)) sum++;
            }
        }

        System.out.println(target);
        System.out.println(sum);
    }
}
