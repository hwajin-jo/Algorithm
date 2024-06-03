package baekjoon.no11478;

import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] input = sc.next().toCharArray();

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < input.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < input.length; j++) {
                sb.append(input[j]);
                set.add(sb.toString());
            }
        }

        System.out.println(set.size());
    }
}
