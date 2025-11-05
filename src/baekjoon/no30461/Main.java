package baekjoon.no30461;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[][] rowSum = new int[N][M];
        int[][] total = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int now = Integer.parseInt(st.nextToken());
                rowSum[i][j] = now;

                if (i > 0)
                    rowSum[i][j] += rowSum[i - 1][j];
                else
                    rowSum[i][j] = now;

                if (i > 0 && j > 0)
                    total[i][j] = total[i - 1][j - 1] + now + rowSum[i - 1][j];
                else
                    total[i][j] = rowSum[i][j];
            }
        }


        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            bw.write(total[a][b] + "\n");
        }

        bw.flush();
        bw.close();

    }
}
