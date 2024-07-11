package baekjoon.no1205;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int score = sc.nextInt();
        int p = sc.nextInt();

        List<Integer> rankList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            rankList.add(sc.nextInt());
        }
        if (n == 0) {
            System.out.println(1);
            return;
        }

        // 1. 점수 들어갈 자리 검사
        int idx = -1;
        if (n == p) {
            for (int i = 0; i < rankList.size(); i++) {
                if (rankList.get(i) < score) {
                    idx = i;
                    break;
                }
            }
        } else {
            for (int i = 0; i < rankList.size(); i++) {
                if (rankList.get(i) < score) {
                    idx = i;
                    break;
                }
            }
            if (idx == -1) {
                idx = rankList.size();
            }
        }


        if (idx == -1) {
            System.out.println(-1);
            return;
        }
        rankList.add(idx, score);

        // 2. 등수 구하기
        int r = 1;
        int prev = rankList.get(0);
        int[] rank = new int[rankList.size()];
        for (int i = 0; i < rankList.size(); i++) {
            if (prev > rankList.get(i)) {
                rank[i] = i+1;
                r = i + 1;
            } else {
                rank[i] = r;
            }
            prev = rankList.get(i);
        }

        System.out.println(rank[idx]);
    }
}
