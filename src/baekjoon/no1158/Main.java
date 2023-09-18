package baekjoon.no1158;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        LinkedList<Integer> linkedList = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            linkedList.add(i);
        }

        ArrayList<Integer> answerList = new ArrayList<>();
        ListIterator<Integer> listIterator = linkedList.listIterator();

        int count = 0;
        while (!linkedList.isEmpty()) {
            if (!listIterator.hasNext())
                listIterator = linkedList.listIterator();

            count++;
            int next = listIterator.next();
            if (count % K == 0) {
                answerList.add(next);
                listIterator.remove();
                count = 0;
            }
        }

        System.out.print("<");
        for (int i = 0; i < answerList.size() - 1; i++) {
            System.out.print(answerList.get(i) + ", ");
        }
        System.out.println(answerList.get(N-1) + ">");
    }
}
