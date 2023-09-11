package baekjoon.no2118;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] distance = new int[N];

        int distanceSum = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            distance[i] = Integer.parseInt(st.nextToken());
            distanceSum += distance[i];
        }

        // 모든 기준 지점 i에서
        // 반시계방향거리 <= 시계방향거리가 되는 경계를 확인한다.
        int pairIndex = 0;
        int distClockWise = 0;
        int distCounterClockwise = distanceSum;
        int ans = 0;
        for (int i = 0; i < N; i++) {
            while (distClockWise < distCounterClockwise) {
                distClockWise += distance[pairIndex];
                distCounterClockwise -= distance[pairIndex];
                pairIndex = (pairIndex + 1) % N;
            }
            ans = Math.max(ans, distCounterClockwise);
            distClockWise -= distance[i];
            distCounterClockwise += distance[i];

        }

        System.out.println(ans);
    }
}
