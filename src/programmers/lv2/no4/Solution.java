package programmers.lv2.no4;

import java.util.LinkedList;

// [1차] 캐시
public class Solution {

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        LinkedList<String> list = new LinkedList<>();

        for (int i = 0; i < cities.length; i++) {
            if (list.size() <= cacheSize) {
                cities[i] = cities[i].toLowerCase();

                if (!list.contains(cities[i])) {
                    list.addLast(cities[i]);
                    answer += 5; // cache miss 인 경우
                } else {
                    answer += 1; // cache hit 인 경우
                    // cache가 hit인 경우 해당 데이터를 삭제한 후 맨 뒤로 옮겨줌(LRU알고리즘 원리)
                    int idx = list.indexOf(cities[i]);
                    list.remove(idx);
                    list.addLast(cities[i]);
                }
            } else {
                list.removeFirst();
                cities[i] = cities[i].toLowerCase();
                if (!list.contains(cities[i])) {
                    list.addLast(cities[i]);
                    answer += 5; // cache miss 인 경우
                } else {
                    answer += 1; // cache hit 인 경우
                    int idx = list.indexOf(cities[i]);
                    list.remove(idx);
                    list.addLast(cities[i]);
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int cacheSize = 2;
        String[] cities = {"A", "A", "B", "A", "C" };

        System.out.println(sol.solution(cacheSize, cities));

    }
}
