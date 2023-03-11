package programmers.lv1.no14;

import java.util.Arrays;

// 로또의 최고 순위와 최저 순
public class Solution {

    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        Arrays.sort(lottos);
        Arrays.sort(win_nums);

        int max_rank = 7;

        for (int i = 0; i < lottos.length; i++) {
           for (int j = 0; j < win_nums.length; j++) {
               if (lottos[i] == win_nums[j] || lottos[i] == 0) {
                   max_rank--;
                   break;
               }
           }
        }

        int min_rank = 7;

        for (int i = 0; i < lottos.length; i++) {
            for (int j = 0; j < win_nums.length; j++) {
                if (lottos[i] == win_nums[j]) {
                    min_rank--;
                    break;
                }
            }
        }


        if (min_rank == 7) {
            min_rank = 6;
        }

        if (max_rank == 7) {
            max_rank = 6;
        }

        answer[0] = max_rank;
        answer[1] = min_rank;

        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] lottos = { 44, 1, 0, 0, 31, 25 };
        int[] win_nums = { 31, 10, 45, 1, 6, 19 };

        System.out.println(sol.solution(lottos, win_nums));
    }


}
