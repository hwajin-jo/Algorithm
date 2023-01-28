package programmers.lv0.no2;

// 합성수 찾기
public class Solution {

    public int solution(int n) {
        int answer = 0;

        for (int i = 4; i <= n; i++) {
            int cnt = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) cnt++;
            }

            if (cnt >= 3) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int n = 10;

        System.out.println(sol.solution(n));
    }
}
