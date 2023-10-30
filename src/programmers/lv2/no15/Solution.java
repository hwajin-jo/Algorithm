package programmers.lv2.no15;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    static List<String> candidateKeys = new ArrayList<>();
    static String[][] relation;
    static String column = "";
    public int solution(String[][] relation) {
        this.relation = relation;

        for (int i = 0; i < relation[0].length; i++) {
            column += i;
        }

        for (int i = 1; i <= relation.length; i++) {
            combination(0, i, column);
        }

        return candidateKeys.size();
    }

    void combination(int start, int r, String column) {
//        if (r == 0 && isValid()) {
//
//            return;
//        }

        for (int i = start; i < relation.length; i++) {
            combination(start + 1, r - 1, column.substring(i));
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String[][] relation = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};

        System.out.println(sol.solution(relation));
    }
}
