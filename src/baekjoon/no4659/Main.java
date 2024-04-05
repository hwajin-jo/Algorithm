package baekjoon.no4659;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            String input = br.readLine();

            if (input.equals("end")) break;

            if (isInvalid(input)) {
                bw.write("<" + input + ">" + " is not acceptable.");
            } else {
                bw.write("<" + input + ">" + " is acceptable.");
            }

            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

    static boolean isInvalid(String input) {
        // 1. 모음 하나 이상
        boolean flag = false;
        for (int i = 0; i < input.length(); i++) {
            char data = input.charAt(i);

            if (isMoeum(data)) {
                flag = true;
                break;
            }
        }

        if (!flag) return true;

        // 2. 모음 3개 연속 자음 3개 연속 불가
        int m = 0;
        int j = 0;
        for (int i = 0; i < input.length(); i++) {
            char data = input.charAt(i);

            if (isMoeum(data)) {
                m++;
                j = 0;
            } else {
                m = 0;
                j++;
            }
            if (m >= 3 || j >= 3) return true;
        }


        // 3. 같은 글자가 연속 두번 금지
        char prev = input.charAt(0);
        for (int i = 1; i < input.length(); i++) {
            char data = input.charAt(i);
            if (prev == data) {
                if (data == 'e' || data =='o') continue;
                return true;
            }

            prev = data;
        }


        return false;
    }

    static boolean isMoeum(char data) {
        return data == 'a' || data == 'e' || data == 'i' || data == 'o' || data == 'u';
    }
}
