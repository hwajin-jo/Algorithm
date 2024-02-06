package baekjoon.no15683;

import java.util.*;

public class Main {

    static int ans = Integer.MAX_VALUE;
    static int n, m;
    static List<CCTV> cctvList;
    static int[][] map;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int[][] cctv1 = {{0}, {1}, {2}, {3}};
    static int[][] cctv2 = {{0, 1}, {2, 3}};
    static int[][] cctv3 = {{0, 2}, {0, 3}, {1, 2}, {1, 3}};
    static int[][] cctv4 = {{0, 1, 2}, {0, 1, 3}, {0, 2, 3}, {1, 2, 3}};
    static int[][] cctv5 = {{0, 1, 2, 3}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][m];
        cctvList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
                if (1 <= map[i][j] && map[i][j] <= 5) {
                    cctvList.add(new CCTV(i, j, map[i][j]));
                }
            }
        }

        solve(0);
        System.out.println(ans);
    }

    static void solve(int idx) {
        if (idx == cctvList.size()) {
            ans = Math.min(ans, countArea());
            return;
        }

        CCTV cctv = cctvList.get(idx);
        if (cctv.v == 1) {
            for (int i = 0; i < cctv1.length; i++) {
                monitor(cctv, cctv1[i], 7);
                solve(idx + 1);
                monitor(cctv, cctv1[i], 0);
            }
        } else if (cctv.v == 2) {
            for (int i = 0; i < cctv2.length; i++) {
                monitor(cctv, cctv2[i], 7);
                solve(idx + 1);
                monitor(cctv, cctv2[i], 0);
            }
        } else if (cctv.v == 3) {
            for (int i = 0; i < cctv3.length; i++) {
                monitor(cctv, cctv3[i], 7);
                solve(idx + 1);
                monitor(cctv, cctv3[i], 0);
            }
        } else if (cctv.v == 4) {
            for (int i = 0; i < cctv4.length; i++) {
                monitor(cctv, cctv4[i], 7);
                solve(idx + 1);
                monitor(cctv, cctv4[i], 0);
            }
        } else if (cctv.v == 5) {
            for (int i = 0; i < cctv5.length; i++) {
                monitor(cctv, cctv5[i], 7);
                solve(idx + 1);
                monitor(cctv, cctv5[i], 0);
            }
        }
    }

    static void monitor(CCTV cctv, int[] d, int data) {
        for (int i = 0; i < d.length; i++) {
            Queue<CCTV> q = new LinkedList<>();
            q.add(cctv);
            while (!q.isEmpty()) {
                CCTV now = q.poll();

                int nr = now.r + dir[d[i]][0];
                int nc = now.c + dir[d[i]][1];

                if (nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
                if (map[nr][nc] == 6) continue;
                map[nr][nc] = data;
                q.add(new CCTV(nr, nc, now.v));
            }
        }
    }

    static int countArea() {
        int res = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0)
                    res++;
            }
        }

        return res;
    }
}

class CCTV {
    int r, c;
    int v;

    public CCTV(int r, int c, int v) {
        this.r = r;
        this.c = c;
        this.v = v;
    }
}