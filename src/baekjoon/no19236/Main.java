package baekjoon.no19236;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    static int maxSum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] arr = new int[4][4];
        List<Fish> fishList = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                int idx = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken()) - 1;

                arr[i][j] = idx;
                fishList.add(new Fish(idx, i, j, dir, true));
            }
        }

        Collections.sort(fishList);

        Fish fish = fishList.get(arr[0][0] - 1);
        Shark shark = new Shark(fish.x, fish.y, fish.dir, fish.idx);
        arr[fish.x][fish.y] = -1;
        fish.isAlive = false;
        dfs(arr, fishList, shark);
        System.out.println(maxSum);
    }

    private static void dfs(int[][] arr, List<Fish> fishList, Shark shark) {
        maxSum = Math.max(maxSum, shark.eatSum);

        // 물고기 순서대로 이동
        for (Fish f : fishList) {
            moveFish(f, arr, fishList);
        }

        // 상어 이동
        for (int d = 1; d < 4; d++) {
            int nx = shark.x + dx[shark.dir] * d;
            int ny = shark.y + dy[shark.dir] * d;

            if (0 <= nx && 0 <= ny && nx < 4 && ny < 4 && arr[nx][ny] > 0) {
                int[][] copyArr = copyArr(arr);
                List<Fish> copyFishList = copyFishList(fishList);

                copyArr[shark.x][shark.y] = 0;
                Fish f = copyFishList.get(copyArr[nx][ny] - 1);
                f.isAlive = false;
                Shark newShark = new Shark(f.x, f.y, f.dir, shark.eatSum + f.idx);
                copyArr[f.x][f.y] = -1;

                dfs(copyArr, copyFishList, newShark);
            }
        }
    }

    private static List<Fish> copyFishList(List<Fish> fishList) {
        List<Fish> copyFishList = new ArrayList<>();

        for (Fish f : fishList) {
            copyFishList.add(new Fish(f.idx, f.x, f.y, f.dir, f.isAlive));
        }

        return copyFishList;
    }

    private static int[][] copyArr(int[][] arr) {
        int[][] copyArr = new int[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                copyArr[i][j] = arr[i][j];
            }
        }

        return copyArr;
    }

    private static void moveFish(Fish f, int[][] arr, List<Fish> fishList) {
        if (!f.isAlive) return;

        for (int d = 0; d < 8; d++) {
            int nd = ( f.dir + d ) % 8;
            int nx = f.x + dx[nd];
            int ny = f.y + dy[nd];

            if (0 <= nx && 0 <= ny && nx < 4 && ny < 4 && arr[nx][ny] > -1) {
                arr[f.x][f.y] = 0;

                if (arr[nx][ny] == 0) {
                    f.x = nx;
                    f.y = ny;
                } else {
                    Fish another = fishList.get(arr[nx][ny] - 1);
                    another.x = f.x;
                    another.y = f.y;
                    arr[f.x][f.y] = another.idx;

                    f.x = nx;
                    f.y = ny;
                }

                arr[nx][ny] = f.idx;
                f.dir = nd;
                return;
            }
        }
    }
}

class Shark {
    int x, y, dir, eatSum;

    public Shark (int x, int y, int dir, int eatSum) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.eatSum = eatSum;
    }
}

class Fish implements Comparable<Fish>{
    int idx;
    int x;
    int y;
    int dir;
    boolean isAlive;

    public Fish(int idx, int x, int y, int dir, boolean isAlive) {
        this.idx = idx;
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.isAlive = isAlive;
    }

    @Override
    public int compareTo(Fish o) {
        return this.idx - o.idx;
    }
}