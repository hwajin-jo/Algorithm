package programmers.lv1.no19;

import java.util.HashMap;
import java.util.Map;

// 완주 하지 못한 선수
public class Main {

    public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> hashMap = new HashMap<>();


        for (int i = 0; i < participant.length; i++)
        {
            hashMap.put(participant[i], hashMap.getOrDefault(participant[i], 0) + 1);
        }

        for (int i = 0; i < completion.length; i++)
        {
            int cnt = hashMap.get(completion[i]);

            hashMap.put(completion[i], cnt-1);
        }

        for (Map.Entry entry : hashMap.entrySet())
        {
            if ((int)entry.getValue() > 0)
                answer += entry.getKey();
        }

        return answer;
    }
}
