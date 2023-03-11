package programmers.lv1.no13;

import java.util.HashMap;

// 가장 가까운 글자
public class Solution {

    public int[] solution(String s) {
        int[] answer = new int[s.length()];

        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (!hashMap.containsKey(s.charAt(i))) answer[i] = -1;
            else answer[i] = i - hashMap.get(s.charAt(i));
            hashMap.put(s.charAt(i), i);
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "banana";

        System.out.println(sol.solution(s));
    }
}
