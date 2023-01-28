package programmers.lv2.no10;

import java.util.Stack;

// 짝지어 제거하기
public class Solution {

    public int solution(String s) {
        Stack<Character> stack = new Stack<>();

        int idx = 0;

        if (s.length() == 0) return 0;

        stack.push(s.charAt(idx++));
        while (idx < s.length()) {
            char c = s.charAt(idx++);
            if (!stack.isEmpty() && stack.peek() == c) stack.pop();
            else stack.push(c);
        }

        return stack.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "baabaa";
        System.out.println(sol.solution(s));
    }
}
