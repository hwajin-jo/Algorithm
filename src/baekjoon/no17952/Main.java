package baekjoon.no17952;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        Stack<Task> stack = new Stack<>();

        int total = 0;
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int task = Integer.parseInt(st.nextToken());

            if (task == 0) {
                if (!stack.isEmpty()) {
                    Task now = stack.pop();
                    int time = now.time - 1;
                    if (time > 0) {
                        stack.push(new Task(now.score, time));
                    } else {
                        total += now.score;
                    }
                }
            } else {
                int score = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken()) - 1;
                if (time == 0) {
                    total += score;
                } else {
                    stack.push(new Task(score, time));
                }
            }
        }

        System.out.println(total);
    }
}

class Task {
    int score;
    int time;

    public Task(int score, int time) {
        this.score = score;
        this.time = time;
    }
}
