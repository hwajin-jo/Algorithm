package baekjoon.no8;

import java.util.Scanner;

// 1316 - 그룹단어체커
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        String[] str = new String[n];

        for (int i = 0; i < n; i++) {
            str[i] = sc.nextLine();
        }

        int cnt = n;
        for (int i = 0; i < str.length; i++) {
            int[] arr = new int[26];
            String temp = str[i];
            int ch = temp.charAt(0) - 'a';
            arr[ch]++;
            for (int j = 1; j < temp.length(); j++) {
                ch = temp.charAt(j) - 'a';

                if (temp.charAt(j-1) != temp.charAt(j)) {
                    arr[ch]++;
                    if (arr[ch] == 2) {
                        cnt--;
                        break;
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}
