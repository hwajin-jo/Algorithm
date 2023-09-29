package baekjoon.no2573;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int N, M;
    static int[][] graph;
    static boolean[][] visited;
    static List<Ice> iceList;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        graph = new int[N][M];
        visited = new boolean[N][M];
        iceList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                graph[i][j] = sc.nextInt();
                if (graph[i][j] > 0) {
                    iceList.add(new Ice(i, j, graph[i][j]));
                }
                visited[i][j] = true;
            }
        }

        for (int year = 1; !iceList.isEmpty(); year++) {
            // 시간이 흐를 때 마다 빙산 녹이기
            for (Ice ice : iceList) {
                for (int j = 0; j < 4; j++) {
                    int nx = ice.x + dx[j];
                    int ny = ice.y + dy[j];

                    if (graph[nx][ny] == 0) ice.height--;
                }
            }

            // 녹은 빙산들의 길이를 한번에 갱신
            for (int i = 0; i < iceList.size(); i++) {
                Ice ice = iceList.get(i);
                if (ice.height <= 0) {
                    graph[ice.x][ice.y] = 0;
                    iceList.set(i, iceList.get(iceList.size()-1));
                    iceList.remove(iceList.size() - 1);
                    i--;
                } else {
                    visited[ice.x][ice.y] = false;
                }
            }

            if (iceList.size() > 0 && dfs(iceList.get(0).x, iceList.get(0).y) != iceList.size()) {
                System.out.println(year);
                System.exit(0);
            }
        }

        System.out.println(0);
    }

    static int dfs(int x, int y) {
        visited[x][y] = true;
        int cnt = 1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (!visited[nx][ny]) cnt += dfs(nx, ny);
        }

        return cnt;
    }
}

class Ice {
    int x;
    int y;
    int height;

    public Ice(int x, int y, int h) {
        this.x = x;
        this.y = y;
        height = h;
    }
}
