package baekjoon.no13;

import java.util.Scanner;

// 10809 - 알파벳 찾기
public class Main {

    public static void main(String[] ars) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        int[] arr = new int[26];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }

        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            int ch = c - 'a';
            if (arr[ch] > -1) {
                continue;
            } else {
                arr[ch] = i;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != -1) {
                System.out.print(arr[i] + " ");
            } else {
                System.out.print(-1 + " ");
            }
        }
    }
}
