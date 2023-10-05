package baekjoon.no2573;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int N, M;
    static int[][] earth;
    static boolean[][] visited;
    static List<Ice> iceList;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        earth = new int[N][M];
        visited = new boolean[N][M];
        iceList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                earth[i][j] = sc.nextInt();
                if (earth[i][j] > 0) {
                    iceList.add(new Ice(i, j, earth[i][j]));
                }

                visited[i][j] = true;
            }
        }

        for (int year = 1; !iceList.isEmpty(); year++) {
            for (Ice ice : iceList) {
                for (int i = 0; i < 4; i++) {
                    int nr = ice.row + dr[i];
                    int nc = ice.col + dc[i];

                    if (earth[nr][nc] == 0) ice.height--;
                }
            }

            for (int i = 0; i < iceList.size(); i++) {
                Ice ice = iceList.get(i);

                if (ice.height <= 0) {
                    earth[ice.row][ice.col] = 0;
                    iceList.set(i, iceList.get(iceList.size()-1));
                    iceList.remove(iceList.size() - 1);
                    i--;
                } else {
                    visited[ice.row][ice.col] = false;
                }
            }

            if (iceList.size() > 0 && dfs(iceList.get(0).row, iceList.get(0).col) != iceList.size()) {
                System.out.println(year);
                System.exit(0);
            }
        }

        System.out.println(0);
    }

    static int dfs(int row, int col) {
        visited[row][col] = true;
        int cnt = 1;
        for (int i = 0 ; i < 4; i++) {
            int nr = row + dr[i];
            int nc = col + dc[i];

            if (earth[nr][nc] > 0 && !visited[nr][nc]) {
                cnt += dfs(nr, nc);
            }
        }

        return cnt;
    }
}

class Ice {
    int row;
    int col;
    int height;

    public Ice(int r, int c, int h) {
        row = r;
        col  = c;
        height = h;
    }
}

