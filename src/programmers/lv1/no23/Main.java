package programmers.lv1.no23;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public String solution(String s) {
        String answer = "";

        String[] word = s.split(" ", - 1);

        for (int i = 0; i < word.length; i++)
        {
            word[i] = word[i].toLowerCase();
            List<Character> list = new ArrayList<>();
            for (int j = 0; j < word[i].length(); j++)
            {
                if (j % 2 == 0)
                {
                    list.add((char) (word[i].charAt(j) - 32));
                }
                else
                {
                    list.add(word[i].charAt(j));
                }
            }

            for (char c : list)
            {
                answer += c;
            }

            if (i < word.length - 1)
                answer += " ";
        }

        return answer;
    }

}
