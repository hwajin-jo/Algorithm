package baekjoon.no3190;

import java.io.*;
import java.util.*;

public class Main {

    static int d = 0;
    // 우 하 좌 상
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;

            arr[r][c] = 1; // 사과 위치
        }

        st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());

        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int sec = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();
            map.put(sec, dir);
        }

        int time = 0;
        List<Point> snake = new ArrayList<>();
        snake.add(new Point(0, 0));

        int nowR = 0;
        int nowC = 0;
        while (true) {
            time++;

            int nr = nowR + dr[d];
            int nc = nowC + dc[d];

            if (isFinish(N, snake, nr, nc)) break; // 벽에 부딪칠 경우 종류

            if (arr[nr][nc] == 1) { // 사과를 만나는 경우 그대로 넣어줌
                arr[nr][nc] = 0;
                snake.add(new Point(nr, nc));
            } else { // 사과가 없는 경우
                snake.add(new Point(nr, nc));
                snake.remove(0); // 꼬리 부분 삭제
            }

            if (map.containsKey(time)) { // 방향 전환
                if (map.get(time).equals("D")) { // 오른쪽으로 방향 전환
                    d += 1;
                    if (d == 4) d = 0;
                } else { // 왼쪽으로 방향 전환
                    d -= 1;
                    if (d == -1) d = 3;
                }

            }

            nowR = nr;
            nowC = nc;
        }

        System.out.println(time);
    }

    private static boolean isFinish(int N, List<Point> snake, int nr, int nc) {
        if (nr < 0 || nc < 0 || nr >= N || nc >= N) return true; // 벽에 부딪히거나

        for (Point point : snake) { // 자기자신과 부딫히는 경우 종료
            if (point.r == nr && point.c == nc)
                return true;
        }

        return false;
    }
}

class Point {
    int r, c;

    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

