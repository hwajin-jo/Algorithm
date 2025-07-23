package programmers.lv1.no21;

import java.util.Arrays;

// K번째수
public class Main {

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++)
        {
            int start = commands[i][0] - 1;
            int end = commands[i][1] - 1;
            int target = commands[i][2] - 1;

            int[] temp = new int[end - start + 1];

            for (int j = 0; j < temp.length; j++)
            {
                temp[j] = array[start+j];
            }

            Arrays.sort(temp);
            answer[i] = temp[target];
        }

        return answer;
    }
}
