package baekjoon.no5397;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        while (T-- > 0) {
            LinkedList<Character> list = new LinkedList<>();
            ListIterator<Character> cursor = list.listIterator();
            StringBuilder sb = new StringBuilder();
            st = new StringTokenizer(br.readLine());
            char[] data = st.nextToken().toCharArray();

            for (char cmd : data) {
                if (cmd == '<') {
                    if (cursor.hasPrevious()) {
                        cursor.previous();
                    }
                } else if (cmd == '>') {
                    if (cursor.hasNext()) {
                        cursor.next();
                    }
                } else if (cmd == '-') {
                    if (cursor.hasPrevious()) {
                        cursor.previous();
                        cursor.remove();
                    }
                } else {
                    cursor.add(cmd);
                }
            }

            for (Character character : list) {
                sb.append(character);
            }

            System.out.println(sb);
        }
    }
}
