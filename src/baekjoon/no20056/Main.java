package baekjoon.no20056;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ClientInfoStatus;
import java.util.*;

public class Main {

    static int N, M, k;
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
    static List<FireBall> fireBalls = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            FireBall fireBall = new FireBall(r, c, m, s, d);
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
        List<FireBall> mergeFireBalls = new ArrayList<>();
        List<FireBall> newFireBalls = new ArrayList<>();
        for (FireBall data : fireBalls) {
            int r = data.r;
            int c = data.c;
            boolean isMerged = false;
            for (FireBall other : fireBalls) {
                if (other.r == r && other.c == c) {
                    mergeFireBalls.add(other);
                    isMerged = true;
                }
            }

            if (!isMerged) {
                newFireBalls.add(new FireBall(data.r, data.c, data.m, data.s, data.d));
            }

            int totalM = 0;
            int totalS = 0;
            int evenD = 0;
            int oddD = 0;
            // 1. 같은 칸에 있는 파이어 볼은 나누어진다.
            for (FireBall fireBall : mergeFireBalls) {
                totalM += fireBall.m;
                totalS += fireBall.s;
                if (fireBall.d % 2 == 0) {
                    evenD++;
                } else {
                    oddD++;
                }
            }

            // 2. 파이어볼은 4개의 파이어볼로 나우어진다.
            for (int z = 0; z < 4; z++) {
                // 1. 질량은 합쳐진 파이어볼 질량의 합 / 5
                int m = totalM / 5;
                // 2. 속력은 (합쳐진 파이어볼 속력의 합) / 합쳐진 파이어볼의 개수
                int s = totalS / mergeFireBalls.size();
                int d = -1;
                // 3. 합쳐지는 파이어볼의 방향이 모두 홀수 or 짝수이면, 방향은 0, 2, 4, 6
                //    그렇지 않으면 1, 3, 5, 7 이 된다.
                if ((evenD == 0 && oddD > 0) || (evenD > 0 && oddD == 0)) {
                    d = z * 2;
                } else {
                    d = (z * 2) + 1;
                }

                // 4. 질량이 0인 파이어 볼은 소멸되어 없어진다.
                if (m > 0) {
                    FireBall newFireBall = new FireBall(r, c, m, s, d);
                    newFireBalls.add(newFireBall);
                }
            }
        }

        fireBalls = new ArrayList<>(newFireBalls);
    }


    static void moveFireBall() {
        for (FireBall fireBall : fireBalls) {
            // 모든 파이어볼은 자신의 방향 d로 s만큼 이동한다.
            int nr = (fireBall.r + dr[fireBall.d] * ( fireBall.s % N ) + N) % N;
            int nc = (fireBall.c + dc[fireBall.d] * ( fireBall.s % N ) + N) % N;

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
