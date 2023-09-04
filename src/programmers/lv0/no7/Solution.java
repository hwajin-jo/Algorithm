package programmers.lv0.no7;

import java.util.HashSet;

public class Solution {

    static int n, m;
    static boolean[] visited;
    static String[] parr = {"aya", "ye", "woo", "ma"};

    static HashSet<String> set = new HashSet<>();

    public static void main(String[] args) {
        n = 4;
        visited = new boolean[n + 1];

        for (int i = 0; i < parr.length ; i++) {
            m = i+1;
            String[] arr = new String[m];
            permutation(0, arr);
        }
    }

    public static void permutation(int depth, String[] arr) {
        if (depth == m) {
            String word = "";
            for (int i = 0; i < m; i++) {
                word += arr[i];
            }
            set.add(word);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = parr[i];
                permutation(depth+1, arr);
                visited[i] = false;
            }
        }
    }
}
