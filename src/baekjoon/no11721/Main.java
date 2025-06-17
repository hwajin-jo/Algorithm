package baekjoon.no11721;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String input = st.nextToken();

        while (input.length() > 10) {
            bw.write(input.substring(0, 10)+"\n");
            input = input.substring(10);
        }

        bw.write(input+"\n");

        bw.flush();
        bw.close();
    }
}
