package programmers.lv2.no14;



import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }

        boolean flag = false;

        int first = 0;
        int second = 0;
        int mixed = 0;

        while(pq.size() >= 2) {

            if (pq.peek() >= K) {
                flag = true;
                break;
            }

            first = pq.poll();
            second = pq.poll();
            mixed = first + (second * 2);
            pq.add(mixed);
            answer++;

            if (pq.peek() >= K) {
                flag = true;
                break;
            }
        }


        if (!flag)
            return -1;


        return answer;
    }
}