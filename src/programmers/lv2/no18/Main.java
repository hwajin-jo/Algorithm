package programmers.lv2.no18;

import java.util.HashMap;

// 의상
public class Main {

    public int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < clothes.length; i++)
        {
            String type = clothes[i][1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }

        for (String s : map.keySet())
        {
            answer *= (int) (map.get(s) + 1); // 해당 의상을 착용할 경우, 하지 않을 경우
        }

        answer--;

        return answer;
    }
}
