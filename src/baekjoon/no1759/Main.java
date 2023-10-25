package baekjoon.no1759;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static int L, C;
    static char[] alphabet;
    static char[] temp;
    static char[] mo = {'a', 'e', 'i', 'o', 'u'};
    static ArrayList<String> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        L = sc.nextInt();
        C = sc.nextInt();

        alphabet = new char[C];
        temp = new char[L];

        for (int i = 0; i < C; i++) {
            alphabet[i] = sc.next().charAt(0);
        }

        Arrays.sort(alphabet);
        combination(0, 0);

//        Collections.sort(list);

        for (String str : list) {
            System.out.println(str);
        }
    }

    static void combination(int start, int depth) {
        if (depth == L) {
            if (check()) {
                StringBuilder data = new StringBuilder();

                for (int i = 0; i < temp.length; i++) {
                    data.append(temp[i]);
                }

                list.add(data.toString());
            }
            return;
        }

        for (int i = start; i < C; i++) {
            temp[depth] = alphabet[i];
            combination(i + 1, depth + 1);
        }
    }

    static boolean check() {
        int mo = 0, ja = 0;
        for (int i = 0; i < temp.length; i++) {
            char c = temp[i];

            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') mo++;
            else ja++;
        }

        if (mo >= 1 && ja >= 2) return true;

        return false;
    }
}
