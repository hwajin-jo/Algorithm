package programmers.lv1.no1;

public class Solution {

    public static long solution(long n) {
        long answer = 0;

        long result = (long) Math.sqrt(n);

        if (result * result == n) {
            answer = (result + 1) * (result + 1);
        } else {
            return -1;
        }

        return answer;
    }

    public static void main(String[] args) {
        long n = 9;
        System.out.println(solution(n));
    }
}
