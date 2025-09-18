package baekjoon.no1620;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        HashMap<String, String> nameMap = new HashMap<>();
        HashMap<String, String> idxMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String name = sc.next();
            nameMap.put(String.valueOf(i + 1), name);
            idxMap.put(name, String.valueOf(i + 1));
        }

        for (int i = 0; i < M; i++) {
            String target = sc.next();

            if (nameMap.get(target) == null) {
                System.out.println(idxMap.get(target));
            } else {
                System.out.println(nameMap.get(target));
            }
        }
    }
}
