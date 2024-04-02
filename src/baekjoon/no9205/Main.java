package baekjoon.no9205;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            boolean[] visited = new boolean[n];
            Point now = new Point(sc.nextInt(), sc.nextInt());

            List<Point> storeList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                storeList.add(new Point(sc.nextInt(), sc.nextInt()));
            }

            storeList.sort((o1, o2) -> {
                if (o1.r == o2.r) {
                    return o1.c - o2.c;
                }

                return o1.r - o2.r;
            });
            Point end = new Point(sc.nextInt(), sc.nextInt());


            String res = solve(now, storeList, end, visited);
            System.out.println(res);

        }
    }

    static String solve(Point start, List<Point> storeList, Point end, boolean[] visited) {
        Queue<Point> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            Point now = q.poll();
            if (getDistance(now, end) <= 1000) {
                return "happy";
            }

            for (int i = 0; i < storeList.size(); i++) {
                if (!visited[i]) {
                    Point store = storeList.get(i);
                    if (getDistance(now, store) <= 1000) {
                        q.add(new Point(store.r, store.c));
                        visited[i] = true;
                    }
                }
            }
        }

        return "sad";
    }

    private static int getDistance(Point now, Point end) {
        return Math.abs(end.r - now.r) + Math.abs(end.c - now.c);
    }
}

class Point {
    int r, c;

    public Point (int r, int c) {
        this.r = r;
        this.c = c;
    }
}
