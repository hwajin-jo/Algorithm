package baekjoon.no22;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            arrayList.add(i+1);
        }

        int cnt = 0;
        int i = 0;

        ArrayList<Integer> result = new ArrayList<>();
        while (!arrayList.isEmpty()) {
            if (i == arrayList.size()) i = 0;

            if (cnt == K-1) {
                int data = arrayList.remove(i);
                result.add(data);
                cnt = 0;
            } else {
                i++;
                cnt++;
            }
        }

        System.out.print("<");
        for (int j = 0; j < result.size(); j++) {
            if (j == result.size() -1) {
                System.out.print(result.get(j));
            } else {
                System.out.print(result.get(j) + ", ");
            }
        }
        System.out.println(">");
    }
}
