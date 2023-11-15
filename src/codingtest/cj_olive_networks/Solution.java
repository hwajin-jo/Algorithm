package codingtest.cj_olive_networks;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n;
    public int solution(int n, int[][] robot, int[][] walls) {
        visited = new boolean[n + 1][n + 1];
        this.n = n;
        Queue<Point> q = new LinkedList<>();

        for (int i = 0; i < robot.length; i++) {
            q.add(new Point(robot[i][0], robot[i][1], 0));
            visited[robot[i][0]][robot[i][1]] = true;
        }

        int k = 1;
        while (!clean()) {
            k++;
            visited = new boolean[n + 1][n + 1];
            while (!q.isEmpty()) {
                Point now = q.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];

                    if (nx <= 0 || ny <= 0 || nx > n || ny > n) continue;
                    if (!visited[nx][ny] && now.m < k) {
                        visited[nx][ny] = true;
                        q.add(new Point(nx, ny, now.m + 1));
                    }
                }
            }
        }

        return k;
    }

    public static boolean clean() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j])
                    return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 3;
        int[][] robot = {{1,3}};
        int[][] walls = {{1, 2, 2, 2}, {1, 3, 2, 3}, {2, 1, 3, 1}, {2, 2, 3, 2}};

        System.out.println(solution.solution(n, robot, walls));
    }
}

class Point {
    int x, y; // 현재 위치
    int m; // 움직이는 횟수
    public Point (int x, int y, int m) {
        this.x = x;
        this.y = y;
        this.m = m;
    }
}