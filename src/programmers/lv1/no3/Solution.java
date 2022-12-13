package programmers.lv1.no3;

public class Solution {

    // 하샤드의 수
    public static boolean solution(int x) {
        boolean answer = true;

        int sum = 0;
        int temp = x;

        while (temp > 0) {
            int result = temp / 10;

            int remain = temp % 10;

            sum += remain;

            temp = result;
        }

        if ( x % sum != 0) {
            return false;
        }


        return answer;
    }

    public static void main(String[] args) {
        int x = 10;

        System.out.println(solution(x));
    }
}
