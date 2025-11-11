package baekjoon.no3190;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int[][] arr;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static Map<Integer, String> map;
    static int times = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < K; i++) {
            String[] apple = br.readLine().split(" ");

            int r = Integer.parseInt(apple[0]) - 1;
            int c = Integer.parseInt(apple[1]) - 1;

            arr[r][c] = 1;
        }

        int L = Integer.parseInt(br.readLine());
        map = new HashMap<>();

        for (int i = 0; i < L; i++) {
            String[] cmd = br.readLine().split(" ");
            map.put(Integer.parseInt(cmd[0]), cmd[1]);
        }

        solve();

        System.out.println(times);
    }

    static void solve() {
        List<Point> list = new ArrayList<>();
        list.add(new Point(0, 0));
        int nowR = 0;
        int nowC = 0;
        int d = 0;
        while (true) {
            times++;
            int nr = nowR + dr[d];
            int nc = nowC + dc[d];

            if (isFinished(nr, nc, list)) {
                break;
            }

            if (arr[nr][nc] == 1) {
                list.add(new Point(nr, nc));
                arr[nr][nc] = 0;
            } else {
                list.remove(0);
                list.add(new Point(nr, nc));
            }

            if (map.containsKey(times)) {
                if (map.get(times).equals("D")) {
                    d += 1;
                    if (d == 4) d = 0;
                } else {
                    d -= 1;
                    if (d == -1) d = 3;
                }
            }

            nowR = nr;
            nowC = nc;
        }
    }

    static boolean isFinished(int r, int c, List<Point> list) {
        if (r < 0 || c < 0 || r >= N || c >= N) return true;

        for (Point p : list) {
            if (p.r == r && p.c == c)
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
