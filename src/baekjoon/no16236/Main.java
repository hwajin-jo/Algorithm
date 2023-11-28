package baekjoon.no16236;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] map = new int[N][N];
        int result = 0;

        PriorityQueue<Shark> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.distance == o2.distance) {
                if (o1.row == o2.row) {
                    return o1.col - o2.col;
                } else {
                    return o1.row - o2.row;
                }
            } else {
                return o1.distance - o2.distance;
            }
        });

        Queue<Shark> q = new LinkedList<>();
        List<Shark> feeds = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();

                if (map[i][j] == 9) {
                    map[i][j] = 0;
                    Shark babyShark = new Shark(i, j, 2, 0, 0);
                    q.add(babyShark);
                }

                if (map[i][j] != 0) {
                    feeds.add(new Shark(i, j, 0, 0, 0));
                }
            }
        }

        if (feeds.isEmpty()) {
            System.out.println(0);
            return;
        }



        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};


        while (true) {
            boolean[][] visited = new boolean[N][N];
            visited[q.peek().row][q.peek().col] = true;

            while (!q.isEmpty()) {
                Shark shark = q.poll();

                for (int i = 0; i < 4; i++) {
                    int nr = shark.row + dr[i];
                    int nc = shark.col + dc[i];

                    if (nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] > shark.size || visited[nr][nc]) continue;
                    visited[nr][nc] = true;
                    if (map[nr][nc] < shark.size && map[nr][nc] != 0){
                        pq.add(new Shark(nr, nc, shark.size, shark.distance + 1, shark.eatCount + 1));
                    }

                    q.add(new Shark(nr, nc, shark.size, shark.distance + 1, shark.eatCount));
                }
            }

            if (pq.isEmpty()) {
                System.out.println(result);
                return;
            }

            Shark shark = pq.poll();
            map[shark.row][shark.col] = 0;
            result += shark.distance;

            if (shark.size == shark.eatCount) {
                shark.size++;
                shark.eatCount = 0;
            }
            q.add(new Shark(shark.row, shark.col, shark.size, 0, shark.eatCount));

            pq.clear();
        }

    }
}

class Shark {
    int row;
    int col;
    int size;
    int distance;
    int eatCount;


    public Shark(int row, int col, int size, int distance, int eatCount) {
        this.row = row;
        this.col = col;
        this.size = size;
        this.distance = distance;
        this.eatCount = eatCount;
    }
}



