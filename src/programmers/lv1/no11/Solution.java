package programmers.lv1.no11;

import java.util.Arrays;

// 문자열 내림차순으로 배치하기
public class Solution {

    public String solution(String s) {
        String answer = "";
        char[] arr = s.toCharArray();
        Arrays.sort(arr);

        for (int i = arr.length - 1; i >= 0; i--) {
            answer += arr[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "Zbcdefg";

        System.out.println(sol.solution(s));
    }
}
