package programmers.lv1.no6;

import java.util.ArrayList;

// 약수의 개수와 덧셈
public class Solution {

    public int solution(int left, int right) {
        int answer = 0;

        ArrayList<Integer> data = new ArrayList<>();

        for (int i = left; i <= right; i++) {
            data.add(i);
        }

        int sum = 0;
        for (int i = 0; i < data.size(); i++) {
            int num = data.get(i);

            int cnt = 0;
            for (int j = 1; j <= num; j++) {
                if (num % j == 0) {
                    cnt++;
                }
            }

            if (cnt % 2 == 0) {
                sum += num;
            } else {
                sum -= num;
            }
        }

        answer = sum;

        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int left = 24;
        int right = 27;

        System.out.println(sol.solution(left, right));
    }
}
