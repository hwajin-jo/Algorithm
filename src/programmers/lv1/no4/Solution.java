package programmers.lv1.no4;

// 콜라츠 추측

public class Solution {
    public static int solution(int num) {
        int cnt = 0;

        long n = (long) num;

        if (num == 1) return cnt;

        while (cnt <= 500) {
            if (n == 1) {
                return cnt;
            }
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = n * 3 + 1;
            }

            cnt++;
        }

        return -1;
    }

    public static void main(String[] args) {
        int num = 626331;
        System.out.println(solution(num));
    }
}
