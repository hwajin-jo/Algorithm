package baekjoon.no20056;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, M, k;
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
    static List<FireBall>[][] board;
    static List<FireBall> fireBalls = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        board = new ArrayList[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            FireBall fireBall = new FireBall(r, c, m, s, d);
            board[r][c].add(fireBall);
            fireBalls.add(fireBall);

        }

        while (k-- > 0) {
            // 파이어볼 이동
            moveFireBall();
            // 파이어볼 합체 및 나누기
            mergeFireBall();
        }

        // 남어있는 파이어볼 질량의 합
        int ans = calculate();
        System.out.println(ans);
    }

    static int calculate() {
        int total = 0;

        for (FireBall fireBall : fireBalls) {;
            total += fireBall.m;
        }

        return total;
    }

    static void mergeFireBall() {
        List<FireBall>[][] newBoard = new ArrayList[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                newBoard[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j].size() >= 2) {
                    int totalM =  0;
                    int totalS = 0;
                    int evenD = 0;
                    int oddD = 0;

                    for (FireBall fireBall : board[i][j]) {
                        totalM += fireBall.m;
                        totalS += fireBall.s;
                        if (fireBall.d % 2 == 0) {
                            evenD++;
                        } else {
                            oddD++;
                        }
                    }

                    int m = totalM / 5;
                    if (m == 0) continue;

                    int s = totalS / board[i][j].size();

                    for (int z = 0; z < 4; z++) {
                        int d = z * 2;
                        if (oddD > 0 && evenD > 0) {
                            d = z * 2 + 1;
                        }
                        FireBall fireBall = new FireBall(i, j, m, s, d);
                        newBoard[i][j].add(fireBall);
                    }
                } else if (board[i][j].size() == 1){
                    newBoard[i][j].add(board[i][j].get(0));
                }
            }
        }

        fireBalls = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (newBoard[i][j].size() > 0) {
                    fireBalls.addAll(newBoard[i][j]);
                }
            }
        }

        board = newBoard;
    }


    static void moveFireBall() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = new ArrayList<>();
            }
        }
        for (FireBall fireBall : fireBalls) {
            int nr = (fireBall.r + dr[fireBall.d] * (fireBall.s % N) + N) % N;
            int nc = (fireBall.c + dc[fireBall.d] * (fireBall.s % N) + N) % N;

            board[nr][nc].add(fireBall);

            fireBall.r = nr;
            fireBall.c = nc;
        }
    }
}

class FireBall {
    int r, c, m, s, d;

    public FireBall(int r, int c, int m, int s, int d) {
        this.r = r;
        this.c = c;
        this.m = m;
        this.s = s;
        this.d = d;
    }
}
