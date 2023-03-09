package baekjoon.no14;

import java.util.Scanner;

// 1152 - 단어의 개수
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        String[] data = str.split(" ");

        int cnt = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i].length() > 0) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
