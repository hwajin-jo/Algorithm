package programmers.lv2.no11;

import java.util.Collections;
import java.util.PriorityQueue;

// 프린터
public class Solution {

    public int solution(int[] priorities, int location) {
        int answer = 0;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < priorities.length; i++) {
            priorityQueue.offer(priorities[i]);
        }

        while (!priorityQueue.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] == priorityQueue.peek()) {
                    if (i == location) {
                        answer++;
                        return answer;
                    }
                    priorityQueue.poll();
                    answer++;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] properties = {1, 1, 9, 1, 1, 1};
        int location = 0;

        System.out.println(sol.solution(properties, location));
    }
}
