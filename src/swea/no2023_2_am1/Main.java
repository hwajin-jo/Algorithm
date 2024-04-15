package swea.no2023_2_am1;

import java.util.*;

public class Main {
    static int L, N;
    static int ans = 0;
    static int[][] map;
    static int[][] arr;
    static Knight[] knights;
    // 상우하좌
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        L = sc.nextInt(); // L * L 체스판 크기
        N = sc.nextInt(); // 기사의 수
        int Q = sc.nextInt(); // 명령의 수
        
        map = new int[L + 1][L + 1];
        for (int i = 1; i <= L; i++) {
            for (int j = 1; j <= L; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        
        knights = new Knight[N + 1];
        arr = new int[L + 1][L + 1];
        for (int i = 1; i <= N; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            int h = sc.nextInt();
            int w = sc.nextInt();
            int k = sc.nextInt();
            knights[i] = new Knight(i, r, c, h , w, k, true);

            for (int rol = r; rol < r + h; rol++) {
                for (int col = c; col < c + w; col++) {
                    arr[rol][col] = i;
                }
            }
        }

        while (Q-- > 0) {
            int idx = sc.nextInt();
            int dir = sc.nextInt();

            if (knights[idx].isAlive)
                move(idx, dir);

        }

        System.out.println(ans);
    }


    static void move(int idx, int d) {
        Queue<Knight> q = new LinkedList<>();
        Stack<Knight> stack = new Stack<>();
        stack.add(knights[idx]);
        Knight knight = knights[idx];
        q.add(knight);
        while (!q.isEmpty()) {
            Knight now = q.poll();

            for (int i = now.r; i < now.r + now.h; i++) {
                for (int j = now.c; j < now.c + now.w; j++) {
                    int nr = i + dr[d];
                    int nc = j + dc[d];

                    if (!isRange(nr, nc)) continue;
                    if (arr[nr][nc] == 0) continue;
                    if (arr[nr][nc] != now.idx) {
                        stack.add(knights[arr[nr][nc]]);
                        q.add(knights[arr[nr][nc]]);
                    }
                }
            }
        }

        while (!stack.isEmpty()) {
            boolean flag = true;
            Knight now = stack.pop();

            for (int i = now.r; i < now.r + now.h; i++) {
                for (int j = now.c; j < now.c + now.w; j++) {
                    int nr = i + dr[d];
                    int nc = j + dc[d];

                    if (!isRange(nr, nc)) flag = false;
                    if (map[nr][nc] == 2) flag = false;
                    if (arr[nr][nc] != 0 && arr[nr][nc] != now.idx) flag = false;
                }
            }

            if (flag) {
                for (int i = now.r + now.h - 1; i >= now.r; i--) {
                    for (int j = now.c + now.w - 1; j >= now.c ; j--) {
                        int nr = i + dr[d];
                        int nc = j + dc[d];
                        arr[i][j] = 0;
                        arr[nr][nc] = now.idx;
                    }
                }
                now.r += dr[d];
                now.c += dc[d];
//                now.h += dr[d];
//                now.w += dc[d];
                if (idx != now.idx)
                    damage(now.idx);
            }
        }
    }

    static void damage(int idx) {
        if (knights[idx].isAlive) {
            int cnt = 0;
            for (int r = knights[idx].r; r < knights[idx].r + knights[idx].h; r++) {
                for (int c = knights[idx].c; c < knights[idx].c + knights[idx].w; c++) {
                    if (!isRange(r, c)) continue;
                    if (map[r][c] == 1) cnt++;
                }
            }

            knights[idx].k -= cnt;
            ans += cnt;
        }

        if (knights[idx].k <= 0) knights[idx].isAlive = false;
    }

    static boolean isRange(int r, int c) {
        return 0 < r && 0 < c && r <= L && c <= L;
    }
    
}


class Knight {
    int idx;
    int r, c, h, w, k;
    boolean isAlive;
    
    public Knight(int idx, int r, int c, int h, int w, int k, boolean isAlive) {
        this.idx = idx;
        this.r = r;
        this.c = c;
        this.h = h;
        this.w = w;
        this.isAlive = isAlive;
    }
}
