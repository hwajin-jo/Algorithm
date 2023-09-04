package baekjoon.no2817;

import java.util.*;

// ALPS식 투표
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt(); // 참가자들의 수
        int n = sc.nextInt(); // 스태프의 수

        ArrayList<Integer>[] total = new ArrayList[n];
        ArrayList<Integer> total_score = new ArrayList<>();

        HashMap<Character, Integer> stepInfo = new HashMap<>();

        char[] names = new char[n];

        for (int i = 0; i < n; i++) {
            total[i] = new ArrayList<>();
            char stepName = sc.next().charAt(0);
            int score = sc.nextInt();

            double cutLine = x * 0.05;

            if (score >= cutLine) {
                stepInfo.put(stepName, 0);
                names[i] = stepName;
                for (int j = 1; j <= 14; j++) {
                    total[i].add(score/j);
                    total_score.add(score / j);
                }
            }
        }

        Collections.sort(total_score, Collections.reverseOrder());

        for (int i = 0; i < names.length; i++) {
            int cnt = 0;
            for (int j = 0; j < 14; j++) {
                if (total[i].contains(total_score.get(j))) {
                    stepInfo.put(names[i], ++cnt);
                }
            }
        }

        for (Map.Entry<Character, Integer> entry : stepInfo.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
