package baekjoon.no16472;

import java.util.Scanner;

public class Main {

    static int[] currentAlphabetFrequency = new int[26];
    static int currentUniqueAlphabetCount = 0;
    static void increaseAlphabet(char ch) {
        if (currentAlphabetFrequency[ch - 'a']++ == 0)
            currentUniqueAlphabetCount++;
    }

    static void decreaseAlphabet(char ch) {
        if (--currentAlphabetFrequency[ch - 'a'] == 0)
            currentUniqueAlphabetCount--;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        char[] nyang = sc.next().toCharArray();

        int ans = 0;
        int nextIndex = 0;
        for (int i = 0; i < nyang.length; i++) {
            while (nextIndex < nyang.length) {
                increaseAlphabet(nyang[nextIndex++]);
                if (currentUniqueAlphabetCount > N) {
                    decreaseAlphabet(nyang[--nextIndex]);
                    break;
                }
            }

            ans = Math.max(ans, nextIndex - i);
            decreaseAlphabet(nyang[i]);
        }

        System.out.println(ans);
    }
}

