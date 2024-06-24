package baekjoon.no9536;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        while (T-- > 0) {
            String[] sounds = br.readLine().split(" ");
            List<String> list = new ArrayList<>();
            while (true) {
                String[] crying = br.readLine().split(" ");

                if (crying[1].equals("does"))
                    break;

                list.add(crying[2]);
            }

            for (int i = 0; i < sounds.length; i++) {
                if (!list.contains(sounds[i]))
                    bw.write(sounds[i] + " ");
            }

            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}
