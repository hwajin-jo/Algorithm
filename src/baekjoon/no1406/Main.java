package baekjoon.no1406;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] L = st.nextToken().toCharArray();

        LinkedList<Character> editor = new LinkedList<>();
        for (char alphabet : L) {
            editor.add(alphabet);
        }

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int cursor = editor.size();
        ListIterator<Character> lit = editor.listIterator(cursor);
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("L")) {
                if (lit.hasPrevious()) {
                    lit.previous();
                }
            } else if (command.equals("D")) {
                if (lit.hasNext()) {
                    lit.next();
                }
            } else if (command.equals("B")) {
                if (lit.hasPrevious()) {
                    lit.previous();
                    lit.remove();
                }
            } else {
                lit.add(st.nextToken().charAt(0));
            }

        }

        for (char alphabet : editor) {
            bw.write(alphabet);
        }
        bw.write("\n");
        bw.flush();
    }
}

