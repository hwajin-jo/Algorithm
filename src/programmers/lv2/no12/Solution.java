package programmers.lv2.no12;

// 주식가격
public class Solution {

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int cnt = 0;
            for (int j = i+1; j < prices.length; j++) {
                if (prices[i] > prices[j]) {
                    cnt++;
                    break;
                } else {
                    cnt++;
                }
            }
            answer[i] = cnt;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] prices = { 1, 2, 3, 2, 3 };

        System.out.println(sol.solution(prices));
    }
}
