package programmers.lv1.no17;

// 크기가 작은 부분문자열
public class Solution {

    public int solution(String t, String p) {
        int answer = 0;

        for (int i = 0; i <= t.length() - p.length(); i++) {
            String str = t.substring(i, i + p.length());

            if (Long.valueOf(str) <= Long.valueOf(p))
                answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String t = "500220839878";
        String p = "7";

        System.out.println(sol.solution(t, p));
    }
}
