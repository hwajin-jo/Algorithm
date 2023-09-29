package baekjoon.no23;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str1 = sc.nextLine();
        String str2 = sc.nextLine();

        int[] count_1 = getAlphabetCountArray(str1);
        int[] count_2 = getAlphabetCountArray(str2);

        int answer = 0;

        for (int i = 0; i < 26; i++) {
            answer += Math.abs(count_1[i] - count_2[i]);
        }

        System.out.println(answer);
    }

    private static int[] getAlphabetCountArray(String str1) {
        int[] count = new int[26];

        for (int i = 0; i < str1.length(); i++) {
            count[str1.charAt(i) - 'a']++;
        }

        return count;
    }
}
