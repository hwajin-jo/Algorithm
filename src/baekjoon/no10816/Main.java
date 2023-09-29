package baekjoon.no10816;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] cards = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cards);

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int x = Integer.parseInt(st.nextToken());

            int lowerBoundIndex = findLowerBoundIndex(cards, x); // x 이상의 값이 처음으로 나타나는 위치
            int upperBoundIndex = findUpperBoundIndex(cards, x); // x 초과의 값이 처음으로 나타나는 위치
            bw.write(upperBoundIndex - lowerBoundIndex + " ");
        }
        bw.write("\n");
        bw.flush();
    }

    private static int findUpperBoundIndex(int[] arr, int x) {
        int upperBoundIndex = arr.length;
        int l = 0, r = arr.length - 1;

        while (l <= r) {
            int m = (l + r) / 2;

            if (arr[m] <= x) l = m + 1;
            else {
                upperBoundIndex = m;
                r = m - 1;
            }
        }
        return upperBoundIndex;
    }

    private static int findLowerBoundIndex(int[] arr, int x) {
        int lowerBoundIndex = arr.length;
        int l = 0, r= arr.length - 1;

        while (l <= r) {
            int m = (l + r) / 2;

            if (arr[m] < x) l = m + 1;
            else {
                lowerBoundIndex = m;
                r = m - 1;
            }
        }
        return lowerBoundIndex;
    }
}
