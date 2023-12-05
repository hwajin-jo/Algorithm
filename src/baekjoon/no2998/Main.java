package baekjoon.no2998;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.next();
        StringBuilder sb = new StringBuilder(input);
        sb.reverse();

        Map<String, String> map = new HashMap<>();

        map.put("000", "0");
        map.put("001", "1");
        map.put("010", "2");
        map.put("011", "3");
        map.put("100", "4");
        map.put("101", "5");
        map.put("110", "6");
        map.put("111", "7");

        StringBuilder ans = new StringBuilder();
        int start = 0;
        while (start < sb.length()) {
            StringBuilder data;
            if (start + 3 < sb.length()) {
                data = new StringBuilder(sb.substring(start, start + 3));
            } else {
                data = new StringBuilder(sb.substring(start));

                while (data.length() < 3) {
                    data.append("0");
                }
            }
            ans.append(map.get(data.reverse().toString()));
            start += 3;
        }

        ans.reverse();
        System.out.println(ans);
    }
}
