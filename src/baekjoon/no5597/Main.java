package baekjoon.no5597;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean[] check = new boolean[31];

        for (int i = 1; i <= 28; i++) {
            int idx = sc.nextInt();
            check[idx] = true;
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 30; i++) {
            if (!check[i]) {
                list.add(i);
            }
        }

        Collections.sort(list);

        System.out.println(list.get(0));
        System.out.println(list.get(1));
    }
}
