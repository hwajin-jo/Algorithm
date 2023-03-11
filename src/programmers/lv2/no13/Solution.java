package programmers.lv2.no13;

import java.util.Arrays;

// 구명 보트
public class Solution {

    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people); // 50 70 80

        int min_index = 0;
        int max_index = people.length - 1;

        while (min_index <= max_index) {
            if (people[min_index] + people[max_index] <= limit) {
                min_index++;
                max_index--;
                answer++;
            } else {
                answer++;
                max_index--;
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] people = {70, 50, 80};
        int limit = 100;

        System.out.println(sol.solution(people, limit));

    }
}
