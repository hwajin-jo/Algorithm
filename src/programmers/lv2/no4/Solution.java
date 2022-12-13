package programmers.lv2.no4;


import java.util.LinkedList;
import java.util.Queue;

// [1차] 캐시
public class Solution {

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        LinkedList<String> queue = new LinkedList<String>();

        for (int i = 0; i < cities.length; i++) {
            if (queue.size() <= cacheSize) {
                cities[i] = cities[i].toLowerCase();
                if (!queue.contains(cities[i])) {
                    queue.offer(cities[i]);
                    answer += 5; // cache miss 인 경우
                } else {
                    // cache가 hit인 경우 해당 데이터를 삭제한 후 맨 뒤로 옮겨주는 코드가 필요(LRU알고리즘 원리)
                    answer += 1; // cache hit 인 경우

                    String data = queue.remove(i);
                    queue.offer(data);

                }
            } else {
                queue.poll();
                cities[i] = cities[i].toLowerCase();
                if (!queue.contains(cities[i])) {
                    queue.offer(cities[i]);
                    answer += 5; // cache miss 인 경우
                } else {
                    answer += 1; // cache hit 인 경우
                    String data = queue.poll();
                    queue.offer(data);
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
