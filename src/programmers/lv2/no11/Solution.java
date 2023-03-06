package programmers.lv2.no11;

// 해시 >  전화번호 목록
public class Solution {

    public boolean solution(String[] phone_book) {
        boolean answer = true;

        for (int i = 0; i < phone_book.length; i++) {
            String origin = phone_book[i];
            for (int j = 1; j < phone_book.length; j++) {
                String test = phone_book[j];
                for (int k = 1; k < test.length(); k++) {
                    String temp = test.substring(0, k);
                    if (temp.equals(origin)) return false;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] phone_book = {"112", "113112", "11311211"};

        System.out.println(sol.solution(phone_book));
    }
}
