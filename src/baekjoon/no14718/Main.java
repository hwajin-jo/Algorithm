package baekjoon.no14718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] enemy = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            enemy[i][0] = Integer.parseInt(st.nextToken());
            enemy[i][1] = Integer.parseInt(st.nextToken());
            enemy[i][2] = Integer.parseInt(st.nextToken());
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    int cnt = 0;

                    for (int n = 0; n < N; n++) {
                        if (enemy[i][0] >= enemy[n][0] && enemy[j][1] >= enemy[n][1] && enemy[k][2] >= enemy[n][2])
                            cnt++;
                    }

                    if (cnt >= K) {
                        ans = Math.min(ans, enemy[i][0] + enemy[j][1] + enemy[k][2]);
                    }
                }
            }
        }

        System.out.println(ans);

    }
}

