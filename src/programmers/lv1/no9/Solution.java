package programmers.lv1.no9;

// 이상한 문자 만들기
public class Solution {

    public String solution(String s) {
        String answer = "";
        String[] strArr = s.split(" ", -1);

        for (int i = 0; i < strArr.length; i++) {
            String word = strArr[i];
            for (int j = 0; j < word.length(); j++) {
                if (j % 2 == 0) {
                    Character ch = word.charAt(j);
                    answer += Character.toUpperCase(ch);
                } else{
                    Character ch = word.charAt(j);
                    answer += Character.toLowerCase(ch);
                }
            }
            if (i < strArr.length - 1) {
                answer += " ";
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String s = "  abc cde ";

        System.out.println(sol.solution(s));
    }
}
