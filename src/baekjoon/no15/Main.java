package baekjoon.no15;

import java.util.HashSet;
import java.util.Scanner;

// 14425 - 문자열 집합
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine(); // 공백제거

        int size = n + m;
        String[] data = new String[m];
        HashSet hashSet = new HashSet();
        for (int i = 0; i < size; i++) {
            if (i < n) {
                String input = sc.nextLine();
                hashSet.add(input);
            } else {
                String input = sc.nextLine();
                data[i-n] = input;
            }
        }



        int cnt = 0;
        for (int i = 0; i < m; i++) {
            if (hashSet.contains(data[i])) cnt++;
        }

        System.out.println(cnt);
    }
}
