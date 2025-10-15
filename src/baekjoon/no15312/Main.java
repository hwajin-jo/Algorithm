package baekjoon.no15312;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] myName = sc.next().toCharArray();
        char[] yourName = sc.next().toCharArray();

        int[] alphabet = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < myName.length; i++) {
            list.add(alphabet[myName[i] - 'A']);
            list.add(alphabet[yourName[i] - 'A']);
        }


        while (list.size() > 2) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < list.size() - 1; i++) {
                temp.add((list.get(i) + list.get(i + 1)) %  10);
            }

            list = temp;
        }

        System.out.println(list.get(0) + "" + list.get(1));
    }
}
