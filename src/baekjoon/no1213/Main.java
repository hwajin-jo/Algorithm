package baekjoon.no1213;

import java.util.*;

public class Main {

    static List<String> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.next();

        int[] alphabet = new int[26];

        for (int i = 0; i < name.length(); i++) {
            alphabet[name.charAt(i) - 'A']++;
        }

        int odd = 0;
        int oddIdx = -1;

        for (int i = 0; i < 26; i++) {
            if (alphabet[i] % 2 == 1) {
                odd++;
                oddIdx = i;
            }
        }

        if (odd > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < alphabet[i] / 2; j++) {
                sb.append((char) (i + 'A'));
            }
        }

        StringBuilder ans = new StringBuilder(sb);
        if (oddIdx != -1) {
            ans.append((char) (oddIdx + 'A'));
        }
        ans.append(sb.reverse());

        System.out.println(ans);
    }
}
