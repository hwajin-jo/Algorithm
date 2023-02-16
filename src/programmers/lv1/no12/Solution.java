package programmers.lv1.no12;

import java.util.Arrays;
import java.util.Comparator;

// 문자열 내 마음대로 정렬하기
public class Solution {

    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings);
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.charAt(n) > o2.charAt(n)) return  1;
                else if (o1.charAt(n) < o2.charAt(n)) return -1;
                else return 0;
            }
        });

        return strings;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] strings = {"sun", "bed", "car"};
        int n = 1;

        System.out.println(sol.solution(strings, n));
    }
}
