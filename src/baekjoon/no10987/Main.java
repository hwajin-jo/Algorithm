package baekjoon.no10987;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] moeum = {'a', 'i', 'e', 'o', 'u'};
        String input = sc.next();

        int ans = 0;

        for (int i = 0; i < input.length(); i++) {
            for (int j = 0; j < moeum.length; j++) {
                if (moeum[j] == input.charAt(i)) ans++;
            }
        }

        System.out.println(ans);
    }
}
