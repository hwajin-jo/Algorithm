package baekjoon.no15683;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int n, m;
    static int ans = Integer.MAX_VALUE;
    static int[][] map;
    static List<Point> cctvList;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][m];
        cctvList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] != 0 && map[i][j] != 6) {
                    cctvList.add(new Point(i, j, map[i][j]));
                }
            }
        }

        solve(0, map);
        System.out.println(ans);
    }

    static void solve(int idx, int[][] map) {
        if (idx == cctvList.size()) {
            ans = Math.min(ans, cntZeroArea(map));
            return;
        }

        Point cctv = cctvList.get(idx);
        int[][] tmp;
        int cctvNum = cctv.n;
        int r = cctv.r;
        int c = cctv.c;
        if (cctvNum == 1) {
            tmp = copyMap(map);
            checkLeft(tmp, r, c);
            solve(idx + 1, tmp);

            tmp = copyMap(map);
            checkRight(tmp, r, c);
            solve(idx + 1, tmp);

            tmp = copyMap(map);
            checkUp(tmp, r, c);
            solve(idx + 1, tmp);

            tmp = copyMap(map);
            checkDown(tmp, r, c);
            solve(idx + 1, tmp);
        } else if (cctvNum == 2) {
            tmp = copyMap(map);
            checkLeft(tmp, r, c);
            checkRight(tmp, r, c);
            solve(idx + 1, tmp);

            tmp = copyMap(map);
            checkUp(tmp, r, c);
            checkDown(tmp, r, c);
            solve(idx + 1, tmp);
        } else if (cctvNum == 3) {
            tmp = copyMap(map);
            checkUp(tmp, r, c);
            checkLeft(tmp, r, c);
            solve(idx + 1, tmp);

            tmp = copyMap(map);
            checkUp(tmp, r, c);
            checkRight(tmp, r, c);
            solve(idx + 1, tmp);

            tmp = copyMap(map);
            checkDown(tmp, r, c);
            checkRight(tmp, r, c);
            solve(idx + 1, tmp);

            tmp = copyMap(map);
            checkDown(tmp, r, c);
            checkLeft(tmp, r, c);
            solve(idx + 1, tmp);
        } else if (cctvNum == 4) {
            tmp = copyMap(map);
            checkUp(tmp, r, c);
            checkLeft(tmp, r, c);
            checkRight(tmp, r, c);
            solve(idx + 1, tmp);

            tmp = copyMap(map);
            checkUp(tmp, r, c);
            checkRight(tmp, r, c);
            checkDown(tmp, r, c);
            solve(idx + 1, tmp);

            tmp = copyMap(map);
            checkDown(tmp, r, c);
            checkLeft(tmp, r, c);
            checkRight(tmp, r, c);
            solve(idx + 1, tmp);

            tmp = copyMap(map);
            checkDown(tmp, r, c);
            checkLeft(tmp, r, c);
            checkUp(tmp, r, c);
            solve(idx + 1, tmp);
        } else if (cctvNum == 5) {
            tmp = copyMap(map);
            checkUp(tmp, r, c);
            checkDown(tmp, r, c);
            checkLeft(tmp, r, c);
            checkRight(tmp, r, c);
            solve(idx + 1, tmp);
        }
    }

    static int cntZeroArea(int[][] map) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) cnt++;
            }
        }

        return cnt;
    }

    static void checkLeft(int[][] tmp, int r, int c) {
        for (int i = c - 1; i >= 0; i--) {
            if (tmp[r][i] == 6) return;
            if (tmp[r][i] != 0) continue;
            tmp[r][i] = -1;
        }
    }

    static void checkRight(int[][] tmp, int r, int c) {
        for (int i = c + 1; i < m; i++) {
            if (tmp[r][i] == 6) return;
            if (tmp[r][i] != 0) continue;
            tmp[r][i] = -1;
        }
    }

    static void checkUp(int[][] tmp, int r, int c) {
        for (int i = r - 1; i >= 0; i--) {
            if (tmp[i][c] == 6) return;
            if (tmp[i][c] != 0) continue;
            tmp[i][c] = -1;
        }
    }

    static void checkDown(int[][] tmp, int r, int c) {
        for (int i = r + 1; i < n; i++) {
            if (tmp[i][c] == 6) return;
            if (tmp[i][c] != 0) continue;
            tmp[i][c] = -1;
        }
    }

    static int[][] copyMap(int[][] map) {
        int[][] tmp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tmp[i][j] = map[i][j];
            }
        }

        return tmp;
    }
}

class Point {
    int r, c, n;

    public Point(int r, int c, int n) {
        this.r = r;
        this.c = c;
        this.n = n;
    }
}