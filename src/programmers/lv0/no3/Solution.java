package programmers.lv0.no3;

// 로그인 성공?
public class Solution {

    public String solution(String[] id_pw, String[][] db) {

        for (String[] data : db) {
            if (data[0].equals(id_pw[0]) && data[1].equals(id_pw[1])) return  "login";
            else if (data[0].equals(id_pw[0]) && !data[1].equals(id_pw[1])) return "wrong pw";
        }

        return "fail";
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] id_pw = {"meosseugi", "1234"};
        String[][] db = {{"meosseugi", ""}, {"sseugi", "1234"}, {"meosseuhhgi", "1234"}};
        System.out.println(sol.solution(id_pw, db));
    }
}
