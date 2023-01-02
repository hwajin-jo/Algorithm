package programmers.lv2.no6;

// 이진 변환 반복하기
public class Solution {

    public int[] solution(String s) {
        int[] answer = new int[2];

        int zero_cnt = 0;
        int total_cnt = 0;
        while (true) {
            if (s.equals("1")) break;
            int one_cnt = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    one_cnt++;
                }
            }
            zero_cnt += s.length() - one_cnt;
            total_cnt++;
            s = Integer.toBinaryString(one_cnt);
        }

        answer[0] = total_cnt;
        answer[1] = zero_cnt;
        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "110010101001";

        System.out.println(sol.solution(s));

    }
}
