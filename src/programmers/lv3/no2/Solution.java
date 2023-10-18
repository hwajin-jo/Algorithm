package programmers.lv3.no2;

import java.util.*;

class Solution {
    static ArrayList<String> list = new ArrayList<>();
    static boolean[] visited;
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];

        dfs(0, "ICN", "ICN", tickets);

        Collections.sort(list);

        return list.get(0).split(" ");
    }

    static void dfs (int depth, String now, String path, String[][] tickets) {
        if(depth == tickets.length) {
            list.add(path);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && now.equals(tickets[i][0])) {
                visited[i] = true;
                dfs(depth + 1, tickets[i][1], path + " " + tickets[i][1], tickets);
                visited[i] = false;
            }

        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
        System.out.println(solution.solution(tickets));
    }
}
