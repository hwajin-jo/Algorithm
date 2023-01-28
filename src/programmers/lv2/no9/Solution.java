package programmers.lv2.no9;

import java.util.ArrayList;

// 영어 끝말잇기
public class Solution {

    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        ArrayList<String> checkWords = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {

            if (checkWords.contains(words[i])) {
                // 사람
                answer[0] = (i % n) + 1;
                // 차례
                answer[1] = (i / n) + 1;
                break;
            }
            checkWords.add(words[i]);

            if (i > 0 && words[i].charAt(0) != words[i-1].charAt(words[i-1].length() -1)) {
                    // 사람
                    answer[0] = (i % n) + 1;
                    // 차례
                    answer[1] = (i / n) + 1;
                    break;
                }

        }

        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int n = 3;
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};

        System.out.println(sol.solution(n, words));
    }
}
