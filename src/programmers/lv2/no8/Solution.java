package programmers.lv2.no8;

import java.util.ArrayList;

public class Solution {

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < cities.length; i++) {
            if (list.contains(cities[i])) { // cache hit일 경우
                list.remove(cities[i]);
                list.add(cities[i]);
                answer += 1;
            } else { // cache miss 일 경우
                list.add(cities[i]);
                answer += 5;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int cacheSize = 3;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};

        System.out.println(sol.solution(cacheSize, cities));
    }
}
