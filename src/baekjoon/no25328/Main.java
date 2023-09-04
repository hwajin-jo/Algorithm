package baekjoon.no25328;

import java.io.*;
import java.util.*;

public class Main {

    static int k;
    static HashSet<String> set = new HashSet<>();
    static TreeSet<String> ansSet = new TreeSet<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String X = sc.next();
        String Y = sc.next();
        String Z = sc.next();
        k = sc.nextInt();

        char[] arr = new char[k];
        combination(X, 0, 0, arr);
        arr = new char[k];
        combination(Y, 0, 0, arr);
        arr = new char[k];
        combination(Z, 0, 0, arr);

        if (!ansSet.isEmpty()) {
            for (String str : ansSet)
                System.out.println(str);
        } else {
            System.out.println(-1);
        }
    }

    public static void combination(String str, int r, int idx, char[] arr) {

        if (k == r) {
            String word = "";
            for (int i = 0; i < arr.length; i++) {
                word += arr[i];
            }
            if (set.contains(word)) {
                ansSet.add(word);
            }
            set.add(word);
        } else {
            for (int i = idx; i < str.length(); i++) {
                arr[r] = str.charAt(i);
                combination(str, r+1, i+1, arr);
            }
        }

    }
}
