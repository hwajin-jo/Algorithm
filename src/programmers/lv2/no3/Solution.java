package programmers.lv2.no3;

public class Solution {

    public int solution(int n) {
        int answer = 0;

        int start = 1;
        int sum = 0;

        while (start <= n) {

            for (int i = start; i <= n; i++) {
                if (sum == n) {
                    answer++;
                    sum = 0;
                    break;
                } else if (sum > n) {
                    sum = 0;
                    break;
                }
                sum += i;
            }
            start++;
        }

        return answer+1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 15;

        System.out.println(solution.solution(n));
    }
}
