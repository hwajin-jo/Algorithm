package programmers.lv0.no4;

public class Solution {

    public int solution(String A, String B) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        sb.append(A);
        
        for (int i = 0; i < A.length(); i++) {
            char c = sb.charAt(A.length()-1);
            sb.deleteCharAt(A.length()-1);
            sb.insert(0, c);
            answer++;
            if (B.equals(sb.toString())) {
                return answer;
            }
        }

        if (answer == A.length()) answer = -1;

        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String A = "hello";
        String B = "ohell";
        System.out.println(sol.solution(A, B));
    }
}
