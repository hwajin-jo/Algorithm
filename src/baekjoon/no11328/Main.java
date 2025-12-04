package baekjoon.no11328;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            String[] data = br.readLine().split(" ");
            String origin = data[0];
            String target = data[1];

            if (origin.length() != target.length()) {
                bw.write("Impossible" + "\n");
                continue;
            }
            int[] alphabet = new int[26];
            for (int i = 0; i < origin.length(); i++) {
                alphabet[origin.charAt(i) - 'a']++;
            }

            boolean isValid = true;
            for (int i = 0; i < target.length(); i++) {
                if (alphabet[target.charAt(i) - 'a'] == 0) {
                    bw.write("Impossible" + "\n");
                    isValid = false;
                    break;
                } else if (alphabet[target.charAt(i) - 'a'] > 0){
                    alphabet[target.charAt(i) - 'a']--;
                }
            }

            if (isValid)
                bw.write("Possible" + "\n");
        }

        bw.flush();
        bw.close();
    }
}
