package programmers.lv1.no15;

import java.util.*;

public class Solution {

    public ArrayList<Integer> solution(int[] numbers) {
        ArrayList<Integer> answer = new ArrayList<>();

        Arrays.sort(numbers);

        HashSet<Integer> hashSet = new HashSet<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                hashSet.add(numbers[i] + numbers[j]);
            }
        }

        Iterator<Integer> it = hashSet.iterator();

        while (it.hasNext()) {
            answer.add(it.next());
        }

        Collections.sort(answer);

        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] numbers = {0,100,1000,10};

        System.out.println(sol.solution(numbers));
    }
}
