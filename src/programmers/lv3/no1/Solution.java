package programmers.lv3.no1;

class Solution {
    static int n;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] computers;
    static boolean[][] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n][n];
        this.computers = computers;
        this.n = n;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && computers[i][j] == 1) {
                    dfs(i, j);
                    answer++;
                }
            }
        }

        return answer;
    }

    public void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
            if(!visited[nx][ny] && computers[nx][ny] == 1) {
                dfs(nx, ny);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 3;
        int[][] computers = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        System.out.println(solution.solution(n, computers));
    }
}