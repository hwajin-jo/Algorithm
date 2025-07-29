package programmers.lv1.no24;

import java.util.*;

// 실패율
public class Main {

    public int[] solution(int N, int[] stages) {
        int[] answer = {};

        Arrays.sort(stages);

        Map<Integer, Integer> map = new HashMap<>();

        int start = 0;

        // 각 스테이지 정보 구하기
        for (int i = start; i < stages.length; i++)
        {
            if (stages[start] < stages[i])
            {
                map.put(stages[start], i - start);
                start = i;
            }
        }

        map.put(stages[start], stages.length - start);

        // 각 스테이지 실패율 구하기
        List<Stage> list = new ArrayList<>();
        int total = stages.length;

        for (int i = 1; i <= N; i++)
        {
            int cnt = map.getOrDefault(i, 0);

            System.out.println("cnt " + cnt + " total " + total);

            double failRate = 0;
            if (total > 0)
            {
                failRate = (double) cnt / total;
                total -= cnt;
            }

            list.add(new Stage(i, failRate));
        }


        list.sort((o1, o2) -> {
            if (o1.failRate == o2.failRate)
            {
                return o1.idx - o2.idx;
            }

            return Double.compare(o2.failRate, o1.failRate);
        });

        answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++)
        {
            answer[i] = list.get(i).idx;

            System.out.println("1. idx = " + list.get(i).idx + " failRate = " + list.get(i).failRate);
        }

        return answer;
    }
}

class Stage {
    int idx;
    double failRate;

    public Stage(int idx, double failRate)
    {
        this.idx = idx;
        this.failRate = failRate;
    }
}
