package LCT.Simulation.no4;

import java.util.Scanner;

// 게임 개발
public class Solution {

    public static int n,m,x,y,direction;

    // 방문한 위치를 저장하기 위한 맵을 생성하여 0으로 초기화
    public static int[][] visit = new int[50][50];

    // 전체 맵 정보
    public static int[][] map = new int[50][50];

    // 북 동 남 서 방향 정의
    static int[] dx = {-1 ,0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void turn_left() {
        direction -= 1;
        if (direction == -1) direction = 3;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        x = sc.nextInt();
        y = sc.nextInt();
        direction = sc.nextInt(); // 0 - 북쪽 / 1 - 동쪽 / 2 - 남쪽 / 3 - 서쪽 /

        // 현재 좌표 방문 처리
        visit[x][y] = 1;

        // 전체 맵 정보 입력받기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        // 시뮬레이션 시작
        int cnt = 1;
        int turn_time = 0;
        while (true) {
            // 왼쪽으로 회전
            turn_left();
            int nx = x + dx[direction];
            int ny = y + dy[direction];

            // 회전한 이후 정면에 가보지 않은 칸이 존재하는 경우 이동
            if (visit[nx][ny] == 0 && map[nx][ny] == 0) {
                visit[nx][ny] = 1;
                x = nx;
                y = ny;
                cnt += 1;
                turn_time = 0;
                continue;
            } else turn_time += 1; // 회전한 이후 정면에 가보지 않은 칸이 없거나 바다인 경우

            // 네 방향 모두 갈 수 없는 경우
            if (turn_time == 4) {
                nx -= dx[direction];
                ny -= dy[direction];
                // 뒤로 갈 수 있는 경우면 뒤로 가기
                if (map[nx][ny] == 0) {
                    x = nx;
                    y = ny;
                } else break; // 뒤가 바다로 막펴있는 경우
                turn_time = 0;
            }
        }
        System.out.println(cnt);
    }
}
