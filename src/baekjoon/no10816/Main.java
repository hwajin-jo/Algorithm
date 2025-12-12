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
        int[] card = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(card);

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            int leftIdx = lowerBound(target, card);
            int rightIdx = UpperBound(target, card);


            int cnt = rightIdx - leftIdx;
            bw.write(cnt + " ");
        }

        bw.flush();
        bw.close();
    }

    static private int lowerBound(int target, int[] card) {
        int left = 0;
        int right = card.length;

        while (left < right) {
            int mid = (right + left) / 2;

            if (card[mid] >= target) {
                right = mid;
            } else if (card[mid] < target) {
                left = mid + 1;
            }
        }

        return left;
    }

    static private int UpperBound(int target, int[] card) {
        int left = 0;
        int right = card.length;

        while (left < right) {
            int mid = (right + left) / 2;

            if (card[mid] > target) {
                right = mid;
            } else if (card[mid] <= target) {
                left = mid + 1;
            }
        }

        return right;
    }
}
