package baekjoon.no20055;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] belt = new int[2 * n + 1];
        boolean[] robot = new boolean[n + 1];
        for (int i = 1; i <= 2 * n; i++) {
            belt[i] = sc.nextInt();
        }

        int cycle = 0;

        while (check(k, belt)) {
            // 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
            int temp = belt[2 * n];
            for (int i = 2 * n; i > 0; i--) {
                belt[i] = belt[i - 1];
            }

            belt[1] = temp;

            // 로봇의 위치를 한칸씩 옮긴다.
            for (int i = n; i > 1; i--) {
                robot[i] = robot[i - 1];
            }
            robot[1] = false;

            // 내리는 위치에 로봇이 있으면 내린다.
            if (robot[n]) {
                robot[n] = false;
            }

            // 2. 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다.
            // 만약 이동할 수 없다면 가만히 있는다.

            for (int i = n - 1; i > 0; i--) {
                if (robot[i] && !robot[i + 1] && belt[i + 1] >= 1) {
                    belt[i + 1]--;
                    robot[i] = false;
                    robot[i + 1] = true;
                }
            }

            //내리는 위치에 로봇이 있으면 내린다.
            if(robot[n]) {
                robot[n] = false;
            }

            //3. 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
            if(belt[1] > 0) {
                robot[1] = true;
                belt[1]--;
            }
            cycle++;
        }

        System.out.println(cycle);
    }

    static boolean check(int max, int[] belt) {
        int cnt = 0;

        for (int i = 1; i < belt.length; i++) {
            if (belt[i] == 0)
                cnt++;
        }

        return cnt < max;
    }
}
