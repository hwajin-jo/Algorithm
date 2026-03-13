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

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if (arr[i][j] > 0) {
                    Shark s = new Shark();

                    s.idx = arr[i][j];
                    s.r = i;
                    s.c = j;
                    sharks.put(s.idx, s);

                    smellOwner[s.r][s.c] = s.idx;
                    leftTime[s.r][s.c] = k;
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            Shark s = sharks.get(i + 1);
            s.dir = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            Shark s = sharks.get(i + 1);
            for (int j = 1; j < 5; j++) {
                st = new StringTokenizer(br.readLine());
                for (int z = 1; z < 5; z++) {
                    s.priority[j][z] = Integer.parseInt(st.nextToken());
                }
            }
        }

        simulate();
    }

    static void simulate() {
        while (time++ < 1000) {
            moveShark();
            decreaseSmellTime();
            createSmellTime();

            if (sharks.size() == 1) {
                System.out.println(time);
                return;
            }
        }

        System.out.println(-1);
    }

    static void createSmellTime() {
        for (Integer idx : sharks.keySet()) {
            Shark s = sharks.get(idx);

            smellOwner[s.r][s.c] = s.idx;
            leftTime[s.r][s.c] = k;
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

    static void moveShark() {
        // 상, 하, 좌, 우
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        Queue<Integer> willRemoved = new LinkedList<>();

        for (Integer idx : sharks.keySet()) {
            Shark s = sharks.get(idx);

            Set<Integer> noSmellSet = new HashSet<>();
            Set<Integer> mySmellSet = new HashSet<>();

            for (int i = 0; i < 4; i++) {
                int nr = s.r + dr[i];
                int nc = s.c + dc[i];

                if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;

                if (smellOwner[nr][nc] == 0) {
                    noSmellSet.add(i + 1);
                } else if (smellOwner[nr][nc] == s.idx) {
                    mySmellSet.add(i + 1);
                }
            }

            int nextDir = s.findNextDir(noSmellSet);
            if (nextDir == 0)
                nextDir = s.findNextDir(mySmellSet);

            arr[s.r][s.c] = 0;
            if (nextDir == 1) {
                s.r -= 1;
            } else if (nextDir == 2) {
                s.r += 1;
            } else if (nextDir == 3) {
                s.c -= 1;
            } else if (nextDir == 4) {
                s.c += 1;
            }


            if (arr[s.r][s.c] == 0 || s.idx < arr[s.r][s.c]) {
                arr[s.r][s.c] = s.idx;
                s.dir = nextDir;
            } else {
                willRemoved.add(s.idx);
            }
        }

        while (!willRemoved.isEmpty()) {
            sharks.remove(willRemoved.poll());
        }
    }
}
class Shark {
    int idx;
    int r, c;
    int dir;
    int[][] priority = new int[5][5];

    Shark() {};

    int findNextDir(Set<Integer> candidates) {
        for (int i = 1; i < 5; i++) {
            if (candidates.contains(priority[dir][i]))
                return priority[dir][i];
        }
        return 0;
    }
}
