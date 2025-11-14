package baekjoon.no11660;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][N];
        int[][] sum = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int prev = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
               sum[i][j] = prev + arr[i][j];
               prev = sum[i][j];
            }
        }



        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()) - 1;
            int y1 = Integer.parseInt(st.nextToken()) - 1;

            int x2 = Integer.parseInt(st.nextToken()) - 1;
            int y2 = Integer.parseInt(st.nextToken()) - 1;

            if (x1 == x2 && y1 == y2) {
                bw.write(arr[x1][y1] + "\n");
            } else {
                bw.write(sum[x2][y2] - sum[x1][y1] + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
