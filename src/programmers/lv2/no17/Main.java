package programmers.lv2.no17;

import java.util.*;

// 전화번호 목록
public class Main {

    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);

        List<String> list = new ArrayList<>(Arrays.asList(phone_book));

        for (int i = 0; i < list.size() - 1; i++)
        {
            String target = list.get(i);

            if (list.get(i+1).startsWith(target))
                return false;
        }

        return answer;
    }
}
