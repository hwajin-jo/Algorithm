package programmers.lv1.no10;

// [1차] 비밀지도
public class Solution {

    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            String temp = Integer.toBinaryString(arr1[i] | arr2[i] );
            // 이진변환 후 앞에 n - len 만큼 0을 붙여주는 작업
            temp = String.format("%" + n + "s", temp);

            answer[i] = temp;

        }

        for (int i = 0; i < n; i++) {
            answer[i] = answer[i].replace("1", "#");
            answer[i] = answer[i].replace("0", " ");
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};

        System.out.println(sol.solution(n, arr1, arr2));
    }
}
