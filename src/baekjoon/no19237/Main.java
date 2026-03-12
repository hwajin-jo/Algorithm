package baekjoon.no19237;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, k;
    static int[][] arr = new int[21][21];
    static int[][] smellOwner = new int[21][21];
    static int[][] leftTime = new int[21][21];
    static Map<Integer, Shark> sharks = new HashMap<>();
    static int time = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // input
        N = Integer.parseInt(st.nextToken()); // 격자판 크기
        M = Integer.parseInt(st.nextToken()); // 상어의 갯수
        k = Integer.parseInt(st.nextToken()); // 냄새 유지 시간

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if (arr[i][j] > 0) {
                    Shark s = new Shark();
                    s.idx = arr[i][j];
                    s.x = i;
                    s.y = j;
                    sharks.put(s.idx, s);

                    smellOwner[i][j] = s.idx;
                    leftTime[i][j] = k;
                }
            }
        }

        // direction of sharks
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            Shark s = sharks.get(i + 1);
            s.dir = Integer.parseInt(st.nextToken());
        }

        // priority of sharks
        for (int i = 0; i < M; i++) {
            Shark s = sharks.get(i + 1);

            for (int j = 0; j < 4; j++) {
                st = new StringTokenizer(br.readLine());

                for (int z = 0; z < 4; z++) {
                    s.priority[j + 1][z + 1] = Integer.parseInt(st.nextToken());
                }
            }
        }

        simulate();
    }

    static void simulate() {
        while (time++ < 1000) {
            moveShark();
            decreaseSmellTime();
            createSmell();

            if (sharks.size() == 1) {
                System.out.println(time);
                return;
            }
        }

        System.out.println(-1);
    }

    // 상어 이동 후 겹친 상어 쫓아내기
    static void moveShark() {
        // 위, 아래, 왼쪽, 오른쪽
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Queue<Integer> willRemove = new LinkedList<>();

        for (Integer idx : sharks.keySet()) {
            Set<Integer> noSmellSet = new HashSet<>();
            Set<Integer> mySmellSet = new HashSet<>();
            Shark s = sharks.get(idx);

            for (int i = 0; i < 4; i++) {
                int nx = s.x + dx[i];
                int ny = s.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                if (smellOwner[nx][ny] == 0) {
                    noSmellSet.add(i + 1);
                } else if (smellOwner[nx][ny] == s.idx) {
                    mySmellSet.add(i + 1);
                }
            }

            // 냄새가 없는 곳부터 스캔하고 자기 냄새 있는 곳을 스캔해서 이동할 방향 구하기
            int nextDir = s.findNextDir(noSmellSet);
            if (nextDir == 0) {
                nextDir = s.findNextDir(mySmellSet);
            }

            // 상어의 이동
            arr[s.x][s.y] = 0;
            if (nextDir == 1) {
                s.x -= 1;
            } else if (nextDir == 2) {
                s.x += 1;
            } else if (nextDir == 3) {
                s.y -= 1;
            } else if (nextDir == 4) {
                s.y += 1;
            }

            // 이동할 위치에 상어가 있으면 경쟁 후 작은 번호가 승리
            if (arr[s.x][s.y] == 0 || s.idx < arr[s.x][s.y]) {
                arr[s.x][s.y] = s.idx;
                s.dir = nextDir;
            } else {
                willRemove.add(s.idx);
            }
        }

        while (!willRemove.isEmpty()) {
            sharks.remove((Integer) willRemove.poll());
        }
    }

    static void decreaseSmellTime() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (leftTime[i][j] == 0) continue;

                leftTime[i][j]--;

                if (leftTime[i][j] == 0)
                    smellOwner[i][j] = 0;
            }
        }
    }

    static void createSmell() {
        for (Integer id : sharks.keySet()) {
            Shark s = sharks.get(id);

            smellOwner[s.x][s.y] = s.idx;
            leftTime[s.x][s.y] = k;
        }
    }
}

class Shark {
    int idx; // 상어 번호
    int x, y; // 현재 좌표
    int dir; // 현재방향
    int[][] priority = new int[5][5]; // 우선순위

    public Shark () { }

    int findNextDir(Set<Integer> candidates) {
        for (int i = 1; i < 5; i++) {
            if (candidates.contains(priority[dir][i])) {
                return priority[dir][i];
            }
        }
        return 0;
    }
}
