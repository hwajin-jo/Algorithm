package baekjoon.no11723;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        HashSet<Integer> set = new HashSet<>();
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if (cmd.equals("add")) {
                int data = Integer.parseInt(st.nextToken());
                set.add(data);
            } else if (cmd.equals("check")) {
                int data = Integer.parseInt(st.nextToken());
                if (set.contains(data)) {
                    bw.write("1" + "\n");
                } else {
                    bw.write("0" + "\n");
                }
            } else if (cmd.equals("remove")) {
                int data = Integer.parseInt(st.nextToken());
                set.remove(data);
            } else if (cmd.equals("toggle")) {
                int data = Integer.parseInt(st.nextToken());
                if (set.contains(data)) {
                    set.remove(data);
                } else {
                    set.add(data);
                }
            } else if (cmd.equals("all")) {
                set.clear();
                for (int i = 1; i <= 20; i++) {
                    set.add(i);
                }
            } else if (cmd.equals("empty")) {
                set.clear();
            }
        }

        bw.flush();
        bw.close();
    }
}
