package programmers.lv1.no16;

public class Solution {

    public int solution(int a, int b, int n) {
        int sum = 0;

        while (n > b) {
            int newCoke = n / a;
            int remainBottle = n % a;
            n = newCoke + remainBottle;

            sum += newCoke;
        }


        return sum;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int a = 3;
        int b = 1;
        int n = 20;

        System.out.println(sol.solution(a, b, n));
    }
}
