package baekjoon.no12100;

import java.util.Scanner;

public class Main {

    static int n;
    static int ans = 0;

    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        solve(0);

        System.out.println(ans);
    }

    static void solve(int cnt) {
        if (cnt == 5) {
            ans = Math.max(ans, getMaxBlock(map));
            return;
        }

        int[][] temp = new int[n][n];
        copyMap(temp, map);

        for (int d = 0; d < 4; d++) {
            switch (d) {
                case 0:
                    up(map);
                    break;
                case 1:
                    down(map);
                    break;
                case 2:
                    left(map);
                    break;
                case 3:
                    right(map);
                    break;
            }
            solve(cnt + 1);
            copyMap(map, temp);
        }
    }

    static void up(int[][] map) {
        for (int i = 0; i < n; i++) {
            int idx = 0;
            for (int j = 1; j < n; j++) {
                int prev = map[idx][i];
                int now = map[j][i];

                if (now != 0) {
                    if (prev == 0) {
                        map[idx][i] = now;
                        map[j][i] = 0;
                    } else if (prev == now) {
                        map[idx][i] *= 2;
                        map[j][i] = 0;
                        idx++;
                    } else {
                        idx++;
                        map[idx][i] = map[j][i];
                        if (idx != j) map[j][i] = 0;
                    }
                }
            }
        }
    }

    static void down(int[][] map) {
        for (int i = 0; i < n; i++) {
            int idx = n - 1;
            for (int j = n - 2; j >= 0; j--) {
                int prev = map[idx][i];
                int now = map[j][i];

                if (now != 0) {
                    if (prev == 0) {
                        map[idx][i] = now;
                        map[j][i] = 0;
                    } else if (prev == now) {
                        map[idx][i] *= 2;
                        map[j][i] = 0;
                        idx--;
                    } else {
                        idx--;
                        map[idx][i] = map[j][i];
                        if (idx != j) map[j][i] = 0;
                    }
                }
            }
        }
    }

    static void left(int[][] map) {
        for (int i = 0; i < n; i++) {
            int idx = 0;
            for (int j = 1; j < n; j++) {
                int prev = map[i][idx];
                int now = map[i][j];

                if (now != 0) {
                    if (prev == 0) {
                        map[i][idx] = now;
                        map[i][j] = 0;
                    } else if (prev == now) {
                        map[i][idx] *= 2;
                        map[i][j] = 0;
                        idx++;
                    } else {
                        idx++;
                        map[i][idx] = map[i][j];
                        if (idx != j) map[i][j] = 0;
                    }
                }
            }
        }
    }

    static void right(int[][] map) {
        for (int i = 0; i < n; i++) {
            int idx = n - 1;
            for (int j = n - 2; j >= 0; j--) {
                int prev = map[i][idx];
                int now = map[i][j];

                if (now != 0) {
                    if (prev == 0) {
                        map[i][idx] = now;
                        map[i][j] = 0;
                    } else if (prev == now) {
                        map[i][idx] *= 2;
                        map[i][j] = 0;
                        idx--;
                    } else {
                        idx--;
                        map[i][idx] = map[i][j];
                        if (idx != j) map[i][j] = 0;
                    }
                }
            }
        }
    }

    static void copyMap(int[][] to, int[][] from) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                to[i][j] = from[i][j];
            }
        }
    }

    static int getMaxBlock(int[][] map) {
        int max = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, map[i][j]);
            }
        }
        return max;
    }
}
