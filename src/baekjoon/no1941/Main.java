package baekjoon.no1941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[][] classroom = new int[5][5];
    static int[] selected = new int[7];
    static boolean[] visited = new boolean[25];
    static boolean[] adjVisited = new boolean[25];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            String input = br.readLine();
            for (int j = 0; j < input.length(); j++) {
                if (input.charAt(j) == 'S')
                    classroom[i][j] = 1;
                else
                    classroom[i][j] = 0;
            }
        }

        find(0, 0, 0);
        System.out.println(ans);
    }

    static void find(int depth, int start, int cntS) {
        if (depth == 7) {
            if (cntS >= 4) { // 이다솜파가 4명 이상이고
                if (bfs()) // 모두 인접해있는 조합이라면
                    ans++; // 카운트 증가
                return;
            }
            return;
        }

        // 25명중 7명을 조합으로 뽑아내는 과정
        for (int i = start; i < 25; i++) {
            visited[i] = true;
            selected[depth] = i;

            if (classroom[i / 5][i % 5] == 1) find(depth + 1, i + 1, cntS + 1);
            else find(depth + 1, i + 1, cntS);

            visited[i] = false;
        }
    }

    static boolean bfs() {
        // selected배열이 모두 인접한 행렬인지 검사
        int cnt = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(selected[0]);

        while (!q.isEmpty()) {
            int now = q.poll();
            adjVisited[now] = true;

            for (int d = 0; d < 4; d++) {
                int nx = (now / 5) + dx[d];
                int ny = (now % 5) + dy[d];

                if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue; // 범위 밖으면 무시
                if (adjVisited[nx * 5 + ny]) continue; // 이미 방문한 적 있는 항목이면 무시
                if (!visited[nx * 5 + ny]) continue; // 방문한적은 없지만 공주후보가 아니라면 무시
                cnt++;
                adjVisited[nx * 5 + ny] = true;
                q.add(nx * 5 + ny);
            }
        }

        return cnt == 7;
    }
}
