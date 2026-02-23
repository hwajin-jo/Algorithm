package baekjoon.no21608;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int[][] seats;
    static int[][] favorite;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        seats = new int[N + 1][N + 1];
        favorite = new int[N * N + 1][4];
        ans = 0;

        for (int i = 0; i < N * N; i++) {
            st = new StringTokenizer(br.readLine());
            int student = Integer.parseInt(st.nextToken());

            for (int j = 0; j < 4; j++) {
                int friend = Integer.parseInt(st.nextToken());
                favorite[student][j] = friend;
            }

            makeSeat(student);
        }

        satisfaction();

        System.out.println(ans);
    }

    private static void satisfaction() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int student = seats[i][j];

                int friend1 = favorite[student][0];
                int friend2 = favorite[student][1];
                int friend3 = favorite[student][2];
                int friend4 = favorite[student][3];

                int cnt = 0;
                for (int d = 0; d < 4; d++) {
                    int nr = i + dr[d];
                    int nc = j + dc[d];

                    if (nr < 1 || nc < 1 || nr > N || nc > N) continue;
                    if (seats[nr][nc] == friend1 || seats[nr][nc] == friend2 || seats[nr][nc] == friend3 || seats[nr][nc] == friend4)
                        cnt++;

                }

                if (cnt == 1) ans += 1;
                else if (cnt == 2) ans += 10;
                else if (cnt == 3) ans += 100;
                else if (cnt == 4) ans += 1000;
            }
        }
    }

    private static void makeSeat(int student) {
        PriorityQueue<Seat> pq = new PriorityQueue<>();

        int friend1 = favorite[student][0];
        int friend2 = favorite[student][1];
        int friend3 = favorite[student][2];
        int friend4 = favorite[student][3];


        // 조건에 만족하는 자리 선정
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (seats[i][j] != 0) continue;

                int favoriteCnt = 0;
                int emptyCnt = 0;
                for (int d = 0; d < 4; d++) {
                    int nr = i + dr[d];
                    int nc = j + dc[d];

                    if (nr < 1 || nc < 1 || nr > N || nc > N) continue;
                    if (seats[nr][nc] == friend1 || seats[nr][nc] == friend2 || seats[nr][nc] == friend3 || seats[nr][nc] == friend4)
                        favoriteCnt++;
                    if (seats[nr][nc] == 0)
                        emptyCnt++;
                }

                pq.add(new Seat(i, j, favoriteCnt, emptyCnt));
            }
        }

        Seat seat = pq.poll();
        seats[seat.r][seat.c] = student;
    }
}

class Seat implements Comparable<Seat> {
    int r;
    int c;
    int favoriteCnt;
    int emptyCnt;

    public Seat (int r, int c, int favoriteCnt, int emptyCnt) {
        this.r = r;
        this.c = c;
        this.favoriteCnt = favoriteCnt;
        this.emptyCnt = emptyCnt;
    }

    @Override
    public int compareTo(Seat o) {
        if (this.favoriteCnt == o.favoriteCnt) {
            if (this.emptyCnt == o.emptyCnt) {
                if (this.r == o.r) {
                    return this.c - o.c;
                }
                return this.r - o.r;
            }
            return o.emptyCnt - this.emptyCnt;
        }
        return o.favoriteCnt - this.favoriteCnt;
    }
}
