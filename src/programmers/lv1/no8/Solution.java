package programmers.lv1.no8;

public class Solution {

    public int solution(int n) {
        int answer = 0;

        for (int i = 1; i < n; i++) {
            if (n % i == 1) {
                answer = i;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 10;

        System.out.println(sol.solution(n));
    }
}
