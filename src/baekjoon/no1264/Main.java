package baekjoon.no1264;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] moeum = {'a', 'e', 'i', 'o', 'u'};

        while (true) {
            String input = br.readLine();

            if (input.equals("#"))
                break;

//            input = input.replace(" ", "");
//            input = input.replace(",", "");
//            input = input.replace(".", "");
//            input = input.replace("!", "");
//            input = input.replace("?", "");

            input = input.replaceAll(" ", "");
            input = input.replaceAll(",|\\.|!|\\?", "");
            input = input.toLowerCase();

            int cnt = 0;
            for (int i = 0; i < input.length(); i++) {
                char data = input.charAt(i);

                for (int j = 0; j < moeum.length; j++) {
                    if (data == moeum[j]) {
                        cnt++;
                        break;
                    }
                }
            }

            System.out.println(cnt);
        }
    }
}
