package swea.no2023_2_pm1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    // 상 우 하 좌  대각선
    static int[] dr = {-1, 0, 1, 0, -1, 1, 1, -1};
    static int[] dc = {0, 1, 0, -1, 1, 1, -1, -1};

    static int[][] map;
    static Santa[] santa;
    static Rudolf rudolf;

    static int n, m, p, c, d;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); // 게임판의 크기
        m = sc.nextInt(); // 게임 턴 수
        p = sc.nextInt(); // 산타의 수
        c = sc.nextInt(); // 루돌프의 힘
        d = sc.nextInt(); // 산타의 힘
        map = new int[n + 1][n + 1];

        rudolf = new Rudolf(sc.nextInt(), sc.nextInt(), -1);
        map[rudolf.r][rudolf.c] = -1;

        santa = new Santa[p + 1];
        for (int i = 1; i <= p; i++) {
            int idx = sc.nextInt();
            int santa_r = sc.nextInt();
            int santa_c = sc.nextInt();

            santa[idx] = new Santa(idx, santa_r, santa_c, 0, true, 0);
            map[santa_r][santa_c] = idx;
        }

        for (int i = 0; i < m; i++) {
            moveRudolf();
            if (!isContinue()) break;
            for (int s = 1; s <= p; s++) {
                if (santa[s].isAlive) {
                    if (santa[s].wakeUp > 0) {
                        santa[s].wakeUp--;
                    } else if (santa[s].wakeUp == 0){
                        moveSanta(santa[s]);
                    }
                }
            }
            if (!isContinue()) break;
            getBonus();
        }

        for (int i = 1; i <= p; i++) {
            System.out.print(santa[i].score + " ");
        }
        System.out.println();
    }

    private static void getBonus() {
        for (int i = 1; i <= p; i++) {
            if (santa[i].isAlive)
                santa[i].score++;
        }
    }

    static void moveRudolf() {
        // 가장 가까운 산타를 찾음.
        int min = Integer.MAX_VALUE;
        List<Santa> list = new ArrayList<>();
        for (int i = 1; i < santa.length; i++) {
            if (!santa[i].isAlive) continue;

            int dis = getDistance(santa[i].r, santa[i].c, rudolf.r, rudolf.c);

            if (min < dis) continue;
            if (min > dis) {
                min = dis;
                list = new ArrayList<>();
            }
            list.add(santa[i]);
        }

        Collections.sort(list);

        Santa san = list.get(0);
        int dir = getDirection(san, rudolf);
        map[rudolf.r][rudolf.c] = 0;
        rudolf.r -= dr[dir];
        rudolf.c -= dc[dir];
        map[rudolf.r][rudolf.c] = -1;

        if (san.r == rudolf.r && san.c == rudolf.c) {
            san.score += c;
            san.r -= dr[dir] * c;
            san.c -= dc[dir] * c;
            if (isRange(san.r, san.c)) {
                san.wakeUp = 2;
                map[san.r][san.c] = san.idx;
                interact(san, dir);
            } else {
                san.isAlive = false;
            }
        }
    }

    static void moveSanta(Santa san) {
        int nd = 4;
        int minDistance = getDistance(san.r, san.c, rudolf.r, rudolf.c);

        for (int d = 0; d < 4; d++) {
            int nr = san.r + dr[d];
            int nc = san.c + dc[d];

            if (!isRange(nr, nc) || map[nr][nc] > 0) continue;

            int distance = getDistance(nr, nc, rudolf.r, rudolf.c);

            if (minDistance <= distance) continue;

            minDistance = distance;
            nd = d;
        }

        if (nd == 4) return;

        int nr = san.r + dr[nd];
        int nc = san.c + dc[nd];

        map[san.r][san.c] = 0;
        san.r = nr;
        san.c = nc;

        if (nr == rudolf.r && nc == rudolf.c) {
            san.score += d;
            san.r -= dr[nd] * d;
            san.c -= dc[nd] * d;
            san.wakeUp = 2;

            if (!isRange(san.r, san.c)) san.isAlive = false;
            else {
                map[san.r][san.c] = san.idx;
                interact(san, nd);
            }
        } else {
            map[nr][nc] = san.idx;
        }
    }

    static void interact(Santa san, int d) {
        boolean isEnd = false;

        while (!isEnd) {
            isEnd = true;

            for (int i = 1; i <= p; i++) {
                Santa temp = santa[i];

                if (san.idx != temp.idx) {
                    if (temp.isAlive && temp.r == san.r && temp.c == san.c) {
                        temp.r -= dr[d];
                        temp.c -= dc[d];

                        if (!isRange(temp.r, temp.c)) temp.isAlive = false;

                        san = temp;
                        map[temp.r][temp.c] = temp.idx;

                        isEnd = false;
                    }
                }
            }
        }
    }

    static boolean isRange(int r, int c) {
        return 0 < r && r <= n && 0 < c && c <= n;
    }

    static int getDirection(Santa santa, Rudolf rudolf) {
        int dir = -1;
        int moveR = rudolf.r - santa.r;
        int moveC = rudolf.c - santa.c;

        if (moveR < 0 && moveC == 0) {
            dir = 0;
        } else if (moveR == 0 && moveC > 0) {
            dir = 1;
        } else if (moveR > 0 && moveC == 0) {
            dir = 2;
        } else if (moveR == 0 && moveC < 0) {
            dir = 3;
        } else if (moveR < 0 && moveC > 0) {
            dir = 4;
        } else if (moveR > 0 && moveC > 0) {
            dir = 5;
        } else if (moveR > 0 && moveC < 0) {
            dir = 6;
        } else if (moveR < 0 && moveC < 0) {
            dir = 7;
        }

        return dir;
    }

    static boolean isContinue() {
        boolean alive = false;
        for (int i = 1; i <= p; i++) {
            if (santa[i].isAlive) {
                alive = true;
                break;
            }
        }

        return alive;
    }

    static int getDistance(int r1, int c1, int r2, int c2) {
        return (int) (Math.pow((r1 - r2), 2)) + (int) Math.pow((c1 - c2), 2);
    }
}
class Rudolf {
    int r,c;
    int d;

    public Rudolf(int r, int c, int d) {
        this.r = r;
        this.c = c;
        this.d = d;
    }
}
class Santa implements Comparable<Santa> {
    int idx; // 산타 번호
    int r, c; // 현재 위치
    int score; // 산타 점수
    boolean isAlive; // true : 정상 false : 게임 아웃 상태
    int wakeUp; // 기절 할 경우 k + 2 번째 턴에서 눈뜸.

    public Santa(int idx, int r, int c, int score, boolean isAlive, int wakeUp) {
        this.idx = idx;
        this.r = r;
        this.c = c;
        this.score = score;
        this.isAlive = isAlive;
        this.wakeUp = wakeUp;
    }

    @Override
    public int compareTo(Santa o) {
        if (this.r == o.r) {
            return o.c - this.c;
        }
        return o.r - this.r;
    }
}
