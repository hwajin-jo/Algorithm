package programmers.lv0.no4;

import java.util.ArrayList;

public class Solution {

    static int n, m;
    static boolean[] visited;
    static String[] parr = {"A", "B", "C", "D"};

    static ArrayList<String> plist = new ArrayList<>();
    static ArrayList<String> clist = new ArrayList<>();

    // 순열
    public static void permutation(int depth, String[] arr) {
        if (depth == m) {
            String word = "";
            for (int i = 0; i < m; i++) {
                word += arr[i];
            }
            plist.add(word);
            return;
        } else {
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

    // 조합
    public static void combination(int depth,int begin, String[] arr) {
        if (depth == m) {
            String word = "";
            for (int i = 0; i < m; i++) {
                word += arr[i];
            }
            clist.add(word);
            return;
        } else {
            for (int i = begin; i < n; i++) {
                arr[depth] = parr[i];
                combination(depth + 1, i + 1, arr);
            }
        }
    }


    public static void main(String[] args) {
        n = 4;
        visited = new boolean[n];

        for (int i = 0; i < parr.length; i++) {
            m = i + 1;
            String[] arr = new String[m];
            permutation(0, arr);
        }

        for (int i = 0; i < parr.length; i++) {
            m = i + 1;
            String[] arr = new String[m];
            combination(0, 0, arr);
        }

        System.out.println("!!!");
    }
}
