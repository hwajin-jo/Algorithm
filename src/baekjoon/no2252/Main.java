package baekjoon.no2252;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // indegree 정보 입력
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            graph.get(src).add(dist);
            indegree[dist]++;
        }

        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int src = q.poll();

            sb.append(src).append(" ");

            for (int dist : graph.get(src)) {
                if (indegree[dist] > 0)
                    indegree[dist]--;

                if (indegree[dist] == 0)
                    q.add(dist);
            }
        }

        System.out.println(sb);
    }
}
