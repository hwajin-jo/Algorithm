package baekjoon.no14981;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<Wheel> wheels = new ArrayList<>();
    static List<Wheel> rotateWheels;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // N극은 0, S극은 1

        // input
        for (int i = 0; i < 4; i++) {
            String data = br.readLine();

            int[] status = new int[8];
            for (int j = 0; j < data.length(); j++) {
                status[j] = data.charAt(j) - '0';
            }

            Wheel wheel = new Wheel(i, 0, status);
            wheels.add(wheel);
        }

        // 회전수
        int K = Integer.parseInt(br.readLine());
        while (K-- > 0) {
            String[] revolve = br.readLine().split(" ");

            int idx = Integer.parseInt(revolve[0]) - 1; // 회전시킬 톱니바퀴 번호
            int dir = Integer.parseInt(revolve[1]); // 1인 경우 - 시계 방향, -1인 경우 반시계 방향

            rotateWheels = new ArrayList<>();
            visited = new boolean[4];

            Wheel wheel = wheels.get(idx);
            wheel.dir = dir;
            rotateWheels.add(wheel);
            visited[idx] = true;

            // 회전 가능한 톱니바퀴 구하기
            canRotate(wheel);
//            if (rotateWheels.size() <= 1) continue;
            // 바퀴 회전
            rotation(rotateWheels);
        }

        // 네 톱니바퀴 점수 합 구하기
        int total = calculate();
        System.out.println(total);
    }

    static int calculate() {
        int total = 0;

        if (wheels.get(0).status[0] == 1) {
            total += 1;
        }
        if (wheels.get(1).status[0] == 1) {
            total += 2;
        }
        if (wheels.get(2).status[0] == 1) {
            total += 4;
        }
        if (wheels.get(3).status[0] == 1) {
            total += 8;
        }

        return total;
    }

    static void rotation(List<Wheel> rotateWheels) {
        for (Wheel wheel : rotateWheels) {
            int[] newStatus = new int[8];
            if (wheel.dir == 1) { // 시계 방향으로 회전
                //7 -> 0, 0 -> 1  1 -> 2 ...
                for (int i = 7; i >= 0; i--) {
                    if (i == 0) newStatus[i] = wheel.status[7];
                    else newStatus[i] = wheel.status[i - 1];
                }
            } else if (wheel.dir == -1) { // 반시계 방향으로 회전
                // 1 -> 0, 2 -> 1, 3 -> 2 ... 0 -> 7
                for (int i = 0; i < 8; i++) {
                    if (i == 7) newStatus[i] = wheel.status[0];
                    else newStatus[i] = wheel.status[i + 1];
                }
            }

            wheel.status = newStatus;
        }
    }

    static void canRotate(Wheel current) {
        int left = current.idx - 1;
        if (left >= 0 && !visited[left]) {
            visited[left] = true;
            Wheel leftWheel = wheels.get(left);
            if (leftWheel.status[2] != current.status[6]) {
                leftWheel.dir = -1 * (current.dir);
                rotateWheels.add(leftWheel);
                canRotate(leftWheel);
            }
        }

        int right = current.idx + 1;
        if (right < 4 && !visited[right]) {
            visited[right] = true;
            Wheel rightWheel = wheels.get(right);
            if (current.status[2] != rightWheel.status[6]) {
                rightWheel.dir = -1 * (current.dir);
                rotateWheels.add(rightWheel);
                canRotate(rightWheel);
            }
        }
    }
}

class Wheel {
    int idx;
    int dir;
    int[] status;

    public Wheel(int idx, int dir, int[] status) {
        this.idx = idx;
        this.dir = dir;
        this.status = status;
    }
}