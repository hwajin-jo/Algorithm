package baekjoon.no15686;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int n, m;
    static int[][] city;
    static boolean[] visited;
    static List<Point> storeList;
    static List<Point> homeList;
    static List<Point> openList;
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n  = sc.nextInt();
        m = sc.nextInt();

        city = new int[n][n];

        homeList = new LinkedList<>();
        storeList = new ArrayList<>();
        openList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                city[i][j] = sc.nextInt();
                if (city[i][j] == 1) {
                    homeList.add(new Point(i, j));
                } else if (city[i][j] == 2) {
                    storeList.add(new Point(i, j));
                }
            }
        }

        visited = new boolean[storeList.size()];
        selectStore(0, 0);

        System.out.println(ans);
    }

    static void selectStore(int idx, int cnt) {
        if (cnt == m) {
            ans = Math.min(ans, calculateDistance());
            return;
        }

        for (int i = idx; i < storeList.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                openList.add(storeList.get(i));
                selectStore(i + 1, cnt + 1);
                openList.remove(storeList.get(i));
                visited[i] = false;
            }
        }
    }

    static int calculateDistance() {
        int sum = 0;

        for (Point home : homeList) {
            int distance = Integer.MAX_VALUE;
            for (Point store : openList) {
                distance = Math.min(distance, Math.abs(home.x - store.x) + Math.abs(home.y - store.y));
            }

            sum += distance;
        }

        return sum;
    }
}

class Point {
    int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}