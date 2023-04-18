package programmers.lv0.no5;

public class Solution {

    public static int solution(String number) {
        int answer = 0;

        String[] keyboard = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};

        String num = "";

        for (int i = 0; i < number.length(); i++) {
            if (num.equals(number)) break;
            int input = number.charAt(i) - '0';

            if (input == 0) {
                num += String.valueOf(input);
            } else {
                num += String.valueOf(input) + String.valueOf(input+1);
            }

            answer++;

            if (num.length() > number.length()) {
                num = num.substring(0, num.length() -1);
                answer++;
            } else {
                if (num.equals(number.substring(0, num.length())) ) {
                    i++;
                } else {
                    num = num.substring(0, i+1);
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String number = "1234567";

        System.out.println(solution(number));
    }
}
