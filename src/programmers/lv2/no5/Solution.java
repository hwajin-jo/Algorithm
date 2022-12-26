package programmers.lv2.no5;

import java.util.ArrayList;
import java.util.Collections;

// 카펫
public class Solution {

    public ArrayList<Integer> solution(int brown, int yellow) {
        ArrayList<Integer> answer = new ArrayList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        int total = brown + yellow;

        for (int i = 1; i <= total; i++) {
            if (total % i ==0) {
                arrayList.add(i);
            }
        }

        Collections.reverse(arrayList);

        for (int i = 0; i <= arrayList.size()/2; i++) {
            int width = arrayList.get(i);
            int height = arrayList.get(arrayList.size() - i - 1);

            if ((width - 2) * (height - 2) == yellow ) {
                answer.add(width);
                answer.add(height);
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int brown = 8;
        int yellow = 1;

        System.out.println(sol.solution(brown, yellow));
    }
}
