package baekjoon.no2386;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] data = br.readLine().split(" ");

            char find = data[0].charAt(0);
            if (find == '#') break;

            if ('A' <= find && find <= 'Z') {
                find += 32;
            }

            int cnt = 0;
            for (int i = 1; i < data.length; i++) {
                data[i] = data[i].toLowerCase();
                for (int j = 0; j < data[i].length(); j++) {
                    if (data[i].charAt(j) == find) cnt++;
                }
            }

            System.out.println(find + " " + cnt);
        }
    }
}
