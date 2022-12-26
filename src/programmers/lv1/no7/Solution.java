package programmers.lv1.no7;

// 콜라 문제
public class Solution {

    public int solution(int a, int b, int n) {
        int answer = 0;

        int result = n / a;
        answer += result;
        while (a <= result) {
            n = n - (a*result) + (b*result);
            answer += b*result;
            result = n / a;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int a = 2;
        int b = 1;
        int n = 20;

        System.out.println(sol.solution(a, b, n));
    }
}
