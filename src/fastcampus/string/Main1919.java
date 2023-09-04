package fastcampus.string;

import java.util.Scanner;

public class Main1919 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str1 = sc.next();
        String str2 = sc.next();

        char[] chArr1 = str1.toCharArray();
        char[] chArr2 = str2.toCharArray();

        int cnt = 0;
        for (int i = 0; i < chArr1.length; i++) {
            for (int j = 0; j < chArr2.length; j++) {
                if (chArr1[i] == chArr2[j]) {
                    cnt++;
                    break;
                }
            }
        }

        int answer = str1.length() + str2.length() - cnt * 2;
        System.out.println(answer);
    }
}
