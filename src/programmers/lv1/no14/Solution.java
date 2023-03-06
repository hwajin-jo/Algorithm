package programmers.lv1.no14;

import java.util.HashMap;

public class Solution {

    public int solution(String s) {
        int answer = 0;
        String temp = "";

        HashMap<String, String> hashMap = new HashMap<>();

        hashMap.put("zero", "0");
        hashMap.put("one", "1");
        hashMap.put("two", "2");
        hashMap.put("three", "3");
        hashMap.put("four", "4");
        hashMap.put("five", "5");
        hashMap.put("six", "6");
        hashMap.put("seven", "7");
        hashMap.put("eight", "8");
        hashMap.put("nine", "9");

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {

            Character c = s.charAt(i);
            int num = c - '0';
            if (num >= 0 && num <= 9) {
                temp += num;
            } else {
                sb.append(c);
                if (hashMap.containsKey(sb.toString())) {
                   temp += hashMap.get(sb.toString());
                   sb.delete(0, sb.length());
                }
            }

        }

        answer = Integer.parseInt(temp);

        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String s = "23four5six7";

        System.out.println(sol.solution(s));
    }
}
