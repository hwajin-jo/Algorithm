package programmers.lv0.no6;

import baekjoon.no22.Main;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {


    public static int solution(String[] kor, String[] usa, String[] incs) {
        int answer = 0;
        int size = kor.length * usa.length;
        String[][] strArr = new String[size][2];

        int k = 0;
        for (int i = 0; i < kor.length; i++) {
            for (int j = 0; j < usa.length; j++) {
                strArr[k][0] = kor[i];
                strArr[k][1] = usa[j];
                k++;
            }
        }

        ArrayList<ArrayList<String>> arrayList = new ArrayList<>();
        for (int i = 0; i < incs.length; i++) {
            String[] days = incs[i].split(" ");
            ArrayList<String> list = new ArrayList<>();


            for (int j = 0; j < days.length; j++) {
                list.add(days[j]);
            }
            arrayList.add(list);
        }

        for (int i = 0; i < strArr.length; i++) {
            ArrayList list = new ArrayList();
            list.add(strArr[i][0]);
            list.add(strArr[i][1]);
            int cnt = 0;
            for (int j = 0; j < arrayList.size(); j++) {
                if (arrayList.get(j).containsAll(list)) cnt++;
            }

            answer = Math.max(cnt, answer);
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] kor = {"AAA", "BCD", "AAAAA", "ZY"};
        String[] usa = { "AB", "AA", "TTTT"};
        String[] incs = {"AB BCD AA AAA TTTT AAAA", "BCD AAA", "AB AAA TTTT BCD", "AA AAAAA AB", "AAA AB BCD"};

        System.out.println(solution(kor, usa, incs));
    }
}
