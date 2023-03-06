package codingtest;

import java.util.*;
import java.io.*;

// 2023/ 02/ 18 현대 오토에버 코딩테스트 복기
// 환경 변수 비교
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        HashMap<String, String> hashMap1 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            String[] data = input.split("=");

            hashMap1.put(data[0], data[1]);
        }

        int m = sc.nextInt();
        sc.nextLine();
        HashMap<String, String> hashMap2 = new HashMap<>();
        for (int i = 0; i < m; i++) {
            String input = sc.nextLine();
            String[] data = input.split("=");
            hashMap2.put(data[0], data[1]);
        }

        int create_cnt = 0;
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (String key : hashMap2.keySet()) {
                if (!hashMap1.containsKey(hashMap2.get(key))) {
                    create_cnt++;
                    arrayList.add(hashMap2.get(i));
                }
            }

        }

        System.out.print(create_cnt + " ");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i) + " ");
        }
    }
}
