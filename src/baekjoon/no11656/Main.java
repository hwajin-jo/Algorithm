package baekjoon.no11656;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder(sc.next());
        int size = sb.length();

        List<String> list = new ArrayList<>();
        list.add(sb.toString());
        for (int i = 0; i < size - 1; i++) {
            list.add(sb.deleteCharAt(0).toString());
        }

        list.sort(String::compareTo);

        for (String data : list) {
            System.out.println(data);
        }
    }
}
