package baekjoon.no1283;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<Character> shortKeyList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String[] options = new String[N];
        shortKeyList = new ArrayList<>();
        int idx = 0;
        while (N-- > 0) {
            String option = br.readLine();

            String shortcutKey = getShortCutKey(option);
            options[idx++] = shortcutKey;
        }

        for (String result : options) {
            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
    }

    private static String getShortCutKey(String word) {
        String[] data = word.split(" ");

        // 1. 만약 단어의 첫 글자 단축키로 지정 되있는지 살펴본다.
        for (int i = 0; i < data.length; i++) {
            char first = data[i].charAt(0);

            if (!shortKeyList.contains(Character.toUpperCase(first))) {
                shortKeyList.add(Character.toUpperCase(first));
                return makeShortCutKey(data, first, i, 0);
            }
        }

        // 2. 왼쪽부터 차례대로 알파벳을 보면서 단축키로 지정 안된 것이 있다면 단축키 지정
        for (int i = 0; i < data.length; i++) {
            String str = data[i];

            for (int j = 0; j < str.length(); j++) {
                char key = str.charAt(j);

                if (!shortKeyList.contains(Character.toUpperCase(key))) {
                    shortKeyList.add(Character.toUpperCase(key));
                    return makeShortCutKey(data, key, i, j);
                }
            }
        }

        // 3. 어떤 것도 단축키로 지정할 수 없다면 그냥 놔둔다.
        return word;
    }

    private static String makeShortCutKey(String[] data, char target, int index, int jndex) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < data.length; i++) {
            String str = data[i];
            for (int j = 0; j < str.length(); j++) {
                if (i == index && j == jndex) {
                    sb.append("[").append(target).append("]");
                } else {
                    sb.append(str.charAt(j));
                }
            }

            if (i < data.length - 1)
                sb.append(" ");
        }

        return sb.toString();
    }

}
