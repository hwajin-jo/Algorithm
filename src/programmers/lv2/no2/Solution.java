package programmers.lv2.no2;

// JadenCase 문자열 만들기
public class Solution {

    public static String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] strArr = s.toLowerCase().split(" ");

        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].length() == 0) {
                sb.append(" ");
                continue;
            }

            sb.append(strArr[i].substring(0,1).toUpperCase());
            sb.append(strArr[i].substring(1, strArr[i].length()));
            sb.append(" ");

        }


        if (!s.substring(s.length()-1, s.length()).equals(" "))  sb.deleteCharAt(sb.lastIndexOf(" "));

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "3people unFollowed me";
 // adgagd 3eagdag
        System.out.println(solution(s));
    }
}
