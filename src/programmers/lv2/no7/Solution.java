package programmers.lv2.no7;

// 다음 큰 숫자
public class Solution {

    public int solution(int n) {
        int answer = 0;

        String binary = Integer.toBinaryString(n);

        int n_cnt = 0;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                n_cnt++;
            }
        }


        int answer_cnt = 0;
        int temp = n;
        while (true) {
            if (n_cnt == answer_cnt) {
                break;
            }else {
                ++temp;
                answer_cnt = 0;
                String temp_binary = Integer.toBinaryString(temp);
                for (int i = 0; i < temp_binary.length(); i++) {
                    if (temp_binary.charAt(i) == '1') {
                        answer_cnt++;
                    }
                }
            }
        }

        answer = temp;
        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 15;

        System.out.println(sol.solution(n));
    }
}
