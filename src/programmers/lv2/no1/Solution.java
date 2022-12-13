package programmers.lv2.no1;

import java.util.ArrayList;

// 최댓값과 최솟값
public class Solution {

    public static String solution(String s) {
        String answer = "";
        String[] numbers = s.split(" ");

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < numbers.length; i++) {
            int number = Integer.parseInt(numbers[i]);

            max = Math.max(number, max);
            min = Math.min(number, min);
        }

        answer = min + " " + max;


        return answer;
    }

    public static void main(String[] args) {
        String s = "-1 -2 -3 -4";

        System.out.println(solution(s));
    }

}
