package programmers.lv1.no5;

// 수박수박수박수박수박수?
public class Solution {

    public String solution(int n) {
        String answer = "";

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                answer += "수";
            } else {
                answer += "박";
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int n = 3;

        System.out.println(solution.solution(n));
    }

}
