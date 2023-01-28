package LCT.DFS_BFS.no1;

import java.util.Scanner;

public class Solution {

    public static int n, m;

    public static int[][] arr = new int[1000][1000];

    public static boolean dfs(int x, int y) {

        // 범위를 벗어나면 종료
        if (x <= -1 || x >= n || y <= -1 || y >= m) {
            return false;
        }
        // 현재 노드를 아직 방문하지 않았다면
        if (arr[x][y] == 0) {
            // 방문 처리 후
            arr[x][y] = 1;

            // 상 하 좌 우의 위치들도 재귀적으로 호출
            dfs(x-1, y);
            dfs(x, y-1);
            dfs(x+1, y);
            dfs(x, y+1);
            return  true;
        }

        return false;
    }


    // 음료수 얼려먹기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine(); // 버퍼 지우기

        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(i,j)) {
                    result += 1;
                }
            }
        }
        System.out.println(result); // 정답 출력
    }
}
