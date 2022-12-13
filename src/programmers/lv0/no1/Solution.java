package programmers.lv0.no1;

// 팩토리얼
public class Solution {

    public static int solution(int n) {
        int answer = 0;
        int i = 1;
        if (n == 1) return 1;

        while (i <= n) {
            int result = factorial(i);

            if (result > n) break;
            i++;
        }


        answer = i - 1;
        return answer;
    }

    public static int factorial(int m) {
        if (m == 1)
            return 1;

        return m * factorial(m-1);
    }

    public static void main(String[] args) {
        int n = 3628800;
        System.out.println(solution(n));
    }
}
