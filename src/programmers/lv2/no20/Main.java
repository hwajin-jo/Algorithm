package programmers.lv2.no20;

import java.util.Arrays;

// h-index
public class Main {

    public int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);

        int min = citations[0];
        int max = citations[citations.length - 1];

        for (int i = 1; i <= citations.length; i++)
        {

            int hIndex = 0;

            for (int j = 0; j < citations.length; j++)
            {
                if (i <= citations[j])
                    hIndex++;
            }


            answer = Math.max(i, answer);
        }

        return answer;
    }
}
