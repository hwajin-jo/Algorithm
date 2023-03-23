package programmers.lv1.no16;

public class Solution {

    public int solution(int a, int b, int n) {
        int answer = 0;

        while (n >= a) {
            answer += (n / a) * b;

            int remain = n % a;
            n = (n / a) * b + remain;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int a = 3;
        int b = 2;
        int n = 10;

        System.out.println(sol.solution(a, b, n));
    }
}
